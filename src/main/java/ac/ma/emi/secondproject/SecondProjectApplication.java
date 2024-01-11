package ac.ma.emi.secondproject;

import ac.ma.emi.secondproject.repositories.ColieRepository;
import ac.ma.emi.secondproject.repositories.HabitantRepository;
import ac.ma.emi.secondproject.schemas.Colie;
import ac.ma.emi.secondproject.schemas.Habitant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondProjectApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SecondProjectApplication.class, args);
	}



}
