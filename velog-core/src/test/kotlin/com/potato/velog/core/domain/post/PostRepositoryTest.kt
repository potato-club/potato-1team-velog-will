package com.potato.velog.core.domain.post

import com.potato.velog.core.domain.member.Member
import com.potato.velog.core.domain.member.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PostRepositoryTest(
    @Autowired
    private val postRepository: PostRepository,

    @Autowired
    private val memberRepository: MemberRepository
) {

    @AfterEach
    fun cleanUp() {
        postRepository.deleteAll()
        memberRepository.deleteAll()
    }

    @Test
    fun 첫번째_페이지를_조회한다() {
        // given
        val prefix = "게시물 제목"

        val member = Member("will.seungho@gmail.com", "password", "name")
        memberRepository.save(member)

        for (i in 1..30) {
            postRepository.save(Post(member.id, "$prefix $i", "$i", PostStatus.POSTED))
        }

        // when
        val posts = postRepository.findWithPagination(null, null, 10)

        // then
        assertThat(posts).hasSize(10)
        assertThat(posts[0].title).isEqualTo("게시물 제목 30")
        assertThat(posts[9].title).isEqualTo("게시물 제목 21")
    }

    @Test
    fun 두번째_페이지를_조회한다() {
        // given
        val prefix = "게시물 제목"

        val member = Member("will.seungho@gmail.com", "password", "name")
        memberRepository.save(member)

        val data = mutableListOf<Post>()
        for (i in 1..30) {
            data += Post(member.id, "$prefix $i", "$i", PostStatus.POSTED)
        }
        postRepository.saveAll(data)

        // when
        val posts = postRepository.findWithPagination(data[20].id, prefix, 10)

        // then
        assertThat(posts).hasSize(10)
        assertThat(posts[0].title).isEqualTo("게시물 제목 20")
        assertThat(posts[9].title).isEqualTo("게시물 제목 11")
    }

    @Test
    fun 마지막_페이지를_이후를_조회한다() {
        // given
        val prefix = "게시물 제목"

        val member = Member("will.seungho@gmail.com", "password", "name")
        memberRepository.save(member)

        for (i in 1..10) {
            postRepository.save(Post(member.id, "$prefix $i", "$i", PostStatus.POSTED))
        }

        // when
        val posts = postRepository.findWithPagination(1L, prefix, 10)

        // then
        assertThat(posts).isEmpty()
    }

    @Test
    fun 제목을_필터로_첫번째_페이지를_조회한다() {
        // given
        val member = Member("will.seungho@gmail.com", "password", "name")
        memberRepository.save(member)

        for (i in 1..10) {
            postRepository.save(Post(member.id, "$i", "$i", PostStatus.POSTED))
        }

        // when
        val posts = postRepository.findWithPagination(null, "1", 100)

        // then
        assertThat(posts).hasSize(2)
        assertThat(posts[0].title).isEqualTo("10")
        assertThat(posts[1].title).isEqualTo("1")
    }

}