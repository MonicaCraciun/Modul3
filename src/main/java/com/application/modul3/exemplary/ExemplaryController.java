package com.application.modul3.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.exemplary.dto.ExemplaryDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/exemplaries")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@PostMapping("/add/{bookId}/{publisherId}")
	public ResponseEntity<Object> createExemplary(@PathVariable Integer bookId, @PathVariable Integer publisherId,
			@RequestBody ExemplaryDTO exemplaryDTO) {
		try {
			Exemplary createdExemplary = exemplaryService.createExemplary(bookId, publisherId,
					exemplaryMapper.exemplaryDTO2Exemplary(exemplaryDTO));
			return ResponseEntity.ok(exemplaryMapper.exemplary2ExemplaryDTO(createdExemplary));
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/list/{bookId}")
	public List<ExemplaryDTO> findExemplariesByBookId(@PathVariable Integer bookId) {
		return exemplaryMapper.exemplaryList2ExemplaryDTOList(exemplaryService.findExemplariesByBookId(bookId));
	}

	@DeleteMapping("delete/{exemplaryId}")
	public void deleteExemplary(@PathVariable Integer exemplaryId) {
		exemplaryService.deleteExemplary(exemplaryId);
	}

}
