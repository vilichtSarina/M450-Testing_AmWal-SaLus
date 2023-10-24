package ch.tbz.task;

import ch.tbz.task.address.Address;
import ch.tbz.task.address.AddressController;
import ch.tbz.task.address.AddressService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressController.class)
class TaskApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AddressController addressController;

	@MockBean
	private AddressService addressService;

	private FakeAddressService fakeAddressService;

	private List<Address> addressList;

	@BeforeEach
	void beforeEach() {
		Address user = new Address();
		user.setId(1);
		user.setFirstname("First");
		user.setLastname("Lastname");

		addressList = new ArrayList<>();
		addressList.add(user);
		fakeAddressService = new FakeAddressService(addressList);

		Mockito.when(addressService.registerAddress(Mockito.any())).thenReturn(user);
		Mockito.when(addressService.getAddressById(1)).thenReturn(Optional.of(user));
	}

	@Test
	public void createAddress() throws Exception {
		Address user = new Address();
		user.setId(1);
		user.setFirstname("First");
		user.setLastname("Lastname");
	}

	@Test
	public void getUserById_found() throws Exception {
		Address user = new Address();
		user.setId(1);
		user.setFirstname("First");
		user.setLastname("Lastname");

		Gson gson = new Gson();

		mockMvc.perform(get("/address")
						.contentType(MediaType.APPLICATION_JSON)
						.content(gson.toJson(user)))
				.andExpect(status().isOk());
	}

	@Test
	public void createAndRetrieve() throws Exception {
		Address user = new Address();
		user.setId(1);
		user.setFirstname("First");
		user.setLastname("Lastname");

		Gson gson = new Gson();

		mockMvc.perform(post("/address")
						.contentType(MediaType.APPLICATION_JSON)
						.content(gson.toJson(user)))
				.andExpect(status().isOk());

		mockMvc.perform(get("/address/1"))
				.andExpect(status().isOk());
	}

	@Test
	public void testService_readAddressById() throws Exception {
		assertThat(fakeAddressService.read(1).getFirstname()).isEqualTo("First");
	}

	@Test
	public void testService_readAll() throws Exception {
		assertThat(fakeAddressService.readAll()).isEqualTo(addressList);
	}

	@Test
	public void testService_isServiceAvailable() throws Exception {
		assertThat(fakeAddressService.isAvailable()).isTrue();
	}

	@Test
	public void testService_update() throws Exception {
		Address newAddress = new Address();
		newAddress.setFirstname("Goofy");
		newAddress.setId(2);
		fakeAddressService.update(addressList.get(0), newAddress);
		assertThat(fakeAddressService.readAll().get(0)).isEqualTo(newAddress);
	}
}
