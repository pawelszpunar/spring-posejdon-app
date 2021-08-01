package com.pawelszpunar.module.blog;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope("singleton")
public class PostMemoryStorageService {
    private static final List<PostDto> STORAGE = new ArrayList<>();
    static {
        STORAGE.add(new PostDto( "Title 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at elementum neque. Curabitur mattis lorem tincidunt tincidunt rhoncus. Proin lobortis lorem nec odio mollis sollicitudin. Donec a sollicitudin enim. Integer sed neque vitae nisi vulputate varius vitae a arcu. Integer bibendum, sapien eget fermentum aliquet, odio velit posuere nunc, ac finibus magna sapien sit amet libero. Sed porta erat sit amet arcu pretium placerat. Nullam posuere ullamcorper nisi, id tristique lacus pellentesque sit amet. Curabitur et est dignissim, condimentum tortor at, ultricies sem. In bibendum augue justo, id lobortis odio posuere ut. Proin rhoncus lacus id tincidunt volutpat. "));
        STORAGE.add(new PostDto( "Title 2", "Aliquam suscipit a justo a facilisis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque vel consequat nisi, pulvinar luctus mauris. In vitae nisl ac tellus lobortis vestibulum vitae at metus. Sed ullamcorper consequat nunc ornare ornare. Proin congue, felis in dictum euismod, nisi eros pharetra odio, sed eleifend lorem nisl ac arcu. Mauris feugiat non quam sit amet luctus. "));
    }
    public Optional<PostDto> getPost(String uuid) {
        return STORAGE
                .stream()
                .filter(post -> post.getUuid().equalsIgnoreCase(uuid)).findFirst();
    }
    public List<PostDto> getPosts() {
        return STORAGE;
    }
    public PostDto create(String title, String text) {
        PostDto post = new PostDto(title, text);
        STORAGE.add(post);
        return post;
    }
}
