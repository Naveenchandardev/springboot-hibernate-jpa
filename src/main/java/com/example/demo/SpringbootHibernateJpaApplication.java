package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.comments.CommentLine;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.entity.repository.PostRepository;

@SpringBootApplication
public class SpringbootHibernateJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateJpaApplication.class, args);
	}
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		Post obj = new Post("post title 2", "post description 2");
		Comment obj1 = new Comment("command1 - 2");
		Comment obj2 = new Comment("command1 -2");
		Comment obj3 = new Comment("command1 - 2");
 		 
		obj.getComment().add(obj1);
		obj.getComment().add(obj2);
		obj.getComment().add(obj3);
		 
		this.postRepository.save(obj);
	}

}
