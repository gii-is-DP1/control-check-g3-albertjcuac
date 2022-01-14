package org.springframework.samples.petclinic.recoveryroom;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	private static final String VIEWS_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	
	private final RecoveryRoomService roomService;
    

	@Autowired
	public RecoveryRoomController(RecoveryRoomService roomService) {
		this.roomService =roomService;
     
	}
	@ModelAttribute("types")
	public Collection<RecoveryRoomType> populateProductTypes() {
		return this.roomService.getAllRecoveryRoomTypes();
	}
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		return VIEWS_ROOM_CREATE_OR_UPDATE_FORM;
	}
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom room, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_ROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.roomService.save(room);
			
			return "welcome";
		}
	}
}
