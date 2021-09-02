package com.potato.velog.service.post

import com.potato.velog.core.domain.post.Post
import com.potato.velog.service.post.dto.request.AddPostRequest
import com.potato.velog.core.domain.post.PostRepository
import com.potato.velog.core.domain.post.PostStatus
import com.potato.velog.core.exception.NotFoundException
import com.potato.velog.service.MemberSetUpTest
import com.potato.velog.service.post.dto.request.UpdatePostRequest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class PostServiceTest(
        @Autowired
        private val postService: PostService,

        @Autowired
        private val postRepository: PostRepository
) : MemberSetUpTest() {

    @AfterEach
    fun cleanUp() {
        super.cleanup()
        postRepository.deleteAll()
    }

    @Test
    fun 새로운_게시글을_등록한다() {
        // given
        val title = "코틀린 1장 정리"
        val content = "<h1>코틀린 1장 정리</h1>\n코틀린은 Jetbrain사에서 ~"
        val status = PostStatus.POSTED

        val request = AddPostRequest(title, content, status)

        // when
        postService.addPost(request, memberId)

        // then
        val posts = postRepository.findAll()
        assertThat(posts).hasSize(1)
        assertThat(posts[0].title).isEqualTo(title)
        assertThat(posts[0].content).isEqualTo(content)
        assertThat(posts[0].status).isEqualTo(status)
        assertThat(posts[0].memberId).isEqualTo(memberId)
    }

    @Test
    fun 등록된_게시글을_수정한다() {
        // given
        val title = "코틀린 1장 정리"
        val content = "<h1>코틀린 1장 정리</h1>\n코틀린은 Jetbrain사에서 ~"
        val status = PostStatus.POSTED

        val post = Post(memberId, title, content, status)
        postRepository.save(post)

        val request = UpdatePostRequest(title, content, status)

        // when
        postService.updatePost(post.id, request, memberId)

        // then
        val posts = postRepository.findAll()
        assertThat(posts).hasSize(1)
        assertThat(posts[0].title).isEqualTo(title)
        assertThat(posts[0].content).isEqualTo(content)
        assertThat(posts[0].status).isEqualTo(status)
        assertThat(posts[0].memberId).isEqualTo(memberId)
    }

    @Test
    fun 해당하는_게시글이_없는경우_NOT_FOUND_에러가_발생한다() {
        // given
        val request = UpdatePostRequest("title", "content", PostStatus.DELETED)

        // when & then
        assertThatThrownBy {
            postService.updatePost(
                    100L,
                    request,
                    memberId
            )
        }.isInstanceOf(NotFoundException::class.java)

    }

}