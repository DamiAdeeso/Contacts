package com.ltp.contacts.web;

import java.util.List;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;

@RestController
@Tag(name = "Contact Controller",description="create and retrieve contacts")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/contact/all" ,produces =MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Contact Controller")
    @Operation(summary = "Retrives all contacts",description = "This Method recovers all Contacts")
    @ApiResponse(responseCode = "200",description = "Succesful Retrival of Contacts")
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
    @GetMapping(value = "/contact/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Contact Controller")
    @Operation(summary = "Get Contact",description = "Returns a contact based on ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "404",description = "Contact not doesnt exist"),
            @ApiResponse(responseCode = "200",description = "Succesful Retrieval of Contact")
    })
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @PostMapping(value = "/contact",produces = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Contact Controller")
    @Operation(summary = "Create Contact",description = "Creates a contact from the provided payload")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201",description = "Succesfully created new contact"),
            @ApiResponse(responseCode = "404",description = "Bad Request:Unsuccessfult Submission")

    })
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

}