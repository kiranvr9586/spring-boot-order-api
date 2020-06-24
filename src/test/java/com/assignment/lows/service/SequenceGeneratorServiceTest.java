package com.assignment.lows.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

@RunWith(MockitoJUnitRunner.class)
public class SequenceGeneratorServiceTest {
	
	@InjectMocks
	SequenceGeneratorService sequenceGeneratorService;

	@Mock
	private MongoOperations mongo;
	
	@Test
	public void testGenerateSequence() {
		sequenceGeneratorService.generateSequence("seqName");
		
	}

}
