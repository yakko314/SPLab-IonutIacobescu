package com.yakko.splab.splabionutiacobescu;

import com.yakko.splab.splabionutiacobescu.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLabIonutIacobescuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpLabIonutIacobescuApplication.class, args);
        System.out.println("test");

        Author a1 = new Author("Sca", "Ji");
//        a1.print();
        Author a2 = new Author("Moto", "Yon");

        Book b = new Book("The End Sky");
        b.addAuthor(a1);
        b.addAuthor(a2);

        Section sec1 = new Section("Yukito's View");
        sec1.add(new Image("Minakami_Yukito.png"));

        Section subsec1 = new Section("Mundanity");
        subsec1.add(new Paragraph("If there's one thing I truly enjoy in life, it would be books. They get you away from reality and show you a new perspective. Right now I'm reading a rather difficult book called Critique of Pure-Reason by Immanuel Kant."));
        subsec1.add(new Paragraph("I don't feel one way or another about it."));
        Section subsec2 = new Section("Discontinuous");
        subsec2.add(new Paragraph("Mamiya, shut the hell up!"));
        sec1.add(subsec1);
        sec1.add(subsec2);
        b.addElement(sec1);
        b.print();
    }

}
