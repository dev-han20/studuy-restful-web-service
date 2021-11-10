package com.corp.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/jpa")
public class UserJpaController {
	private final UserRepository userRepository;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveAllUsers(@PathVariable("id") Long id) {
		return userRepository.findById(id).get();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}

	@PostMapping("/users/{id}")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();

		return ResponseEntity.created(uri).build();
	}

}
