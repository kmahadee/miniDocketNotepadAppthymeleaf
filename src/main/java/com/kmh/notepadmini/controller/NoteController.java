package com.kmh.notepadmini.controller;

import com.kmh.notepadmini.entity.Note;
import com.kmh.notepadmini.repository.NoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // List all notes - redirects from / to /notes
    @GetMapping
    public String listNotes(Model model) {
        model.addAttribute("notes", noteRepository.findAll());
        model.addAttribute("newNote", new Note());
        return "index";
    }

    // Create a new note
    @PostMapping
    public String createNote(@ModelAttribute Note note) {
        noteRepository.save(note);
        return "redirect:/notes";
    }

    // Delete a note
    @PostMapping("/{id}/delete")
    public String deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return "redirect:/notes";
    }
}
