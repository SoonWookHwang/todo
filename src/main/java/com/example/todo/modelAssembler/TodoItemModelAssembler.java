package com.example.todo.modelAssembler;

import com.example.todo.controllers.AuthorController;
import com.example.todo.controllers.TodoItemController;
import com.example.todo.entities.TodoItem;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TodoItemModelAssembler implements RepresentationModelAssembler<TodoItem, EntityModel<TodoItem>> {

    @Override
    public EntityModel<TodoItem> toModel(TodoItem entity) {
        return EntityModel.of(entity, //
                linkTo(methodOn(TodoItemController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(TodoItemController.class).all()).withRel("todoItem"));
    }
}
