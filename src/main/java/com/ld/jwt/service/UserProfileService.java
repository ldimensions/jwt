package com.ld.jwt.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ld.jwt.model.AddressModel;
import com.ld.jwt.model.PhoneModel;
import com.ld.jwt.model.ProfileModel;
import com.ld.jwt.model.UserProfileModel;
import com.ld.jwt.entity.Address;
import com.ld.jwt.entity.Phone;
import com.ld.jwt.entity.User;
import com.ld.jwt.repository.AddressRepository;
import com.ld.jwt.repository.PhoneRepository;
import com.ld.jwt.repository.UserRepository;

@Service
public class UserProfileService {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Autowired 
	private PhoneRepository phoneRepository;
	
	private final Logger log = LoggerFactory.getLogger(UserProfileService.class);
	
    public UserProfileModel getProfile(String userName) {
    	User user = userRepository.findByUserName(userName);
    	
		UserProfileModel userProfile = new UserProfileModel();
		
		userProfile.setFirstName(user.getFirstName());
		userProfile.setMiddleName(user.getMiddleName());
		userProfile.setLastName(user.getLastName());  
		userProfile.setUsername(user.getUserName());  
		userProfile.setEmail(user.getEmail());
		userProfile.setAddress(user.getAddress());
		userProfile.setPhone(user.getPhone());
		
        return userProfile;
    }

	public List<Address> getAddress(Long userId) {
		
		List<Address> address = addressRepository.findAddressByUserId(userId);
		return address;		
	}
	
	public List<Phone> getPhone(Long userId) {
		
		List<Phone> phone = phoneRepository.findPhoneByUserId(userId);
		return phone;		
	}
	
    public Integer updateProfile(ProfileModel profileModel, Long userId) {
    	
    	profileModel.setLastModifiedBy((int) (long) userId);
    	profileModel.setUpdatedAt(new Date());

        return userRepository.updateProfile(profileModel, userId);
    }
    
    public Integer updateAddress(List<AddressModel> addressModel, Long userId) {

    	int returnVal = 0;
    	
    	for (int i = 0; i < addressModel.size(); i++) {			
    		addressModel.get(i).setUpdatedAt(new Date());
    		addressModel.get(i).setLastModifiedBy((int) (long) userId);
    		if(addressModel.get(i).getId() != null) {
    			Long id = (Long) addressModel.get(i).getId();
    			addressModel.get(i).setId(id);
    			returnVal = addressRepository.updateAddress(addressModel.get(i));
    		} else {
    			//addressRepository.addAddress(addressModel.get(i), userId);
    		}
    		
		}
    	return returnVal;
    }
    
    public Integer updatePhone(List<PhoneModel> phoneModel, Long userId) {

    	int returnVal = 0;
    	
    	for (int i = 0; i < phoneModel.size(); i++) {			
    		phoneModel.get(i).setUpdatedAt(new Date());
    		phoneModel.get(i).setLastModifiedBy((int) (long) userId);
    		if(phoneModel.get(i).getId() != null) {
    			Long id = (Long) phoneModel.get(i).getId();
    			phoneModel.get(i).setId(id);
    			returnVal = phoneRepository.updatePhone(phoneModel.get(i));
    		} else {
    			//addressRepository.addAddress(addressModel.get(i), userId);
    		}    		
		}
    	return returnVal;
    }

}
