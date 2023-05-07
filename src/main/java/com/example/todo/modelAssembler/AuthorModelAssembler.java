package com.example.todo.modelAssembler;

import com.example.todo.controllers.AuthorController;
import com.example.todo.entities.Author;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AuthorModelAssembler implements RepresentationModelAssembler<Author, EntityModel<Author>> {
    @Override
    public EntityModel<Author> toModel(Author author) {

        return EntityModel.of(author, //
                linkTo(methodOn(AuthorController.class).one(author.getId())).withSelfRel(),
                linkTo(methodOn(AuthorController.class).all()).withRel("authors"));
    }
}
