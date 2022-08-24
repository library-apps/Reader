package com.books.reader;

// import org.junit.jupiter.api.Test;
// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
// import com.books.reader.repository.ReaderRepository;
import com.netflix.discovery.shared.Application;
// import com.books.reader.model.Reader;

@SpringBootTest
// @DataMongoTest
@ContextConfiguration(classes=Application.class)
// @AutoConfigureTestDatabase(replace = Replace.NONE)
class ReaderApplicationTests {
	// @Autowired
	// ReaderRepository readerRepository;

	// @Test
	// void insert() throws Exception{
	// 	// List<Reader> readerList = new ArrayList<>();

	// 	Reader reader1 = new Reader();

	// 	reader1.setReader_name("Sarindu Udagepala");
	// 	reader1.setAddress("Jalan Medium dot com");
	// 	reader1.setEmail("sarindu@gmail.com");
	// 	reader1.setGender("Male");
	// 	reader1.setIs_borrower(1);
	// 	reader1.setPhone(8123);

	// 	// readerList.add(reader1);
	// 	readerRepository.save(reader1);

	// }

}
