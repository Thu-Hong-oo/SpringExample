package iuh.fit.se.services.impl;

import org.springframework.stereotype.Service;

import iuh.fit.se.entities.Address;
import iuh.fit.se.repositories.AddressRepository;
import iuh.fit.se.services.AddressService;

@Service
public class AddressServiceIml implements AddressService {

	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return this.addressRepository.save(address);
	}
	
}
