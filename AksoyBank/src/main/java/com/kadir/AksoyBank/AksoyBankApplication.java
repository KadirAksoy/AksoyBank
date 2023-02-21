package com.kadir.AksoyBank;

//import com.kadir.AksoyBank.model.Address;
//import com.kadir.AksoyBank.model.Customer;
//import com.kadir.AksoyBank.repository.AddressRepository;
//import com.kadir.AksoyBank.repository.CustomerRepository;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.util.Arrays;

@SpringBootApplication
public class AksoyBankApplication {


//	private final CustomerRepository customerRepository;
//	private final AddressRepository addressRepository;
//
//	public AksoyBankApplication(CustomerRepository customerRepository, AddressRepository addressRepository) {
//		this.customerRepository = customerRepository;
//		this.addressRepository = addressRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AksoyBankApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Customer c1 = Customer.builder()
//				.id(1)
//				.name("kadir")
//				.tcNo("11111111111")
//				.phoneNumber("22222222222")
//				.address(Address.builder().city("istanbul").street("zeytinburnu").build())
//				.build();
//
//		Customer c2 = Customer.builder()
//				.id(2)
//				.name("baran")
//				.tcNo("33333333333")
//				.phoneNumber("44444444444")
//				.address(Address.builder().city("Ankara").street("keçiören").build())
//				.build();
//
//		Customer c3 = Customer.builder()
//				.id(3)
//				.name("aksoy")
//				.tcNo("55555555555")
//				.phoneNumber("66666666666")
//				.address(Address.builder().city("izmir").street("kordon").build())
//				.build();
//
//		customerRepository.saveAll(Arrays.asList(c1,c2,c3));
//
//	}
}
