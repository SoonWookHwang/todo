package com.example.todo.service;

import com.example.todo.dto.BucketDto;
import com.example.todo.model.Author;
import com.example.todo.model.Bucket;
import com.example.todo.model.ToDoItem;
import com.example.todo.repository.AuthorRepository;
import com.example.todo.repository.BucketRepository;
import com.example.todo.repository.ToDoItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BucketService implements BucketServiceInterface {

  private final BucketRepository bucketRepository;
  private final AuthorRepository authorRepository;
  private final ToDoItemRepository toDoItemRepository;

  @Override
  public Bucket createBucket(BucketDto bucketDto, Long authorId) {
    Author found = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));

    Bucket bucket = bucketDto.builder()
        .bucketName(bucketDto.getBucketName())
        .author(found)
        .build();

    return bucketRepository.save(bucket);
  }

  @Override
  public Long getBucket(Long bucketId) {
    return null;
  }

  @Override
  public Long updateBucket(BucketDto bucketDto, Long bucketId) {
    return null;
  }

  @Override
  public List<ToDoItem> getTodoItems(Long bucketId) {
    return null;
  }

  @Override
  public String getAuthorNameByBucketId(Long bucketId) {
    return null;
  }
}
