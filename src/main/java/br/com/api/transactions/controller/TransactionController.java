package br.com.api.transactions.controller;

import br.com.api.transactions.dto.TransactionDto;
import br.com.api.transactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping(path = "transaction")
    public ResponseEntity<Void> save(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.save(transactionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "transaction")
    public ResponseEntity<Void> deleteAll(){
        transactionService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
