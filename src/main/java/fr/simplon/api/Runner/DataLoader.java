package fr.simplon.api.Runner;

import fr.simplon.api.Models.Card;
import fr.simplon.api.Models.Line;
import fr.simplon.api.Models.Product;
import fr.simplon.api.Models.User;
import fr.simplon.api.Repositoy.CardRepository;
import fr.simplon.api.Repositoy.LineRepository;
import fr.simplon.api.Repositoy.ProductRepository;
import fr.simplon.api.Repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;
    private final ProductRepository productRepository;
    private final LineRepository lineRepository;
    private final CardRepository cardRepository;
    private LocalDateTime creationDate;

    @Autowired
    public DataLoader(CardRepository cardRepository, UserRepository userRepository, ProductRepository productRepository, LineRepository lineRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.lineRepository = lineRepository;
        this.productRepository = productRepository;
    }


    public void run(ApplicationArguments args) throws Exception {

        // creation utilisateurs
        User userOli = userRepository.save(new User("Oli"));
        User userMomo = userRepository.save(new User("Momo"));
        User userJC = userRepository.save(new User("JC"));

        // creation produits
        Product productChaise = productRepository.save(new Product("Chaise", 49.99F));
        Product productTable = productRepository.save(new Product("Table", 449.99F));
        Product productTV = productRepository.save(new Product("TV", 1999.99F));
        Product productCanap = productRepository.save(new Product("Canap", 999.99F));

        // creation du panier Oli avec 2 lignes
        Card newCardOli = new Card(userOli);
        newCardOli.setCreationDate(LocalDateTime.now());
        newCardOli = cardRepository.save(newCardOli);

        List<Line> linesOli = newCardOli.getLines();
        linesOli.add(lineRepository.save(new Line(productCanap, 2)));
        linesOli.add(lineRepository.save(new Line(productChaise, 6)));
        linesOli.add(lineRepository.save(new Line(productTable, 1)));
        linesOli.add(lineRepository.save(new Line(productTV, 1)));
        cardRepository.save(newCardOli);

        // -----------

        Card newCard2 = new Card(userMomo);
        newCard2.setCreationDate(LocalDateTime.now());
        cardRepository.save(newCard2);

        Card newCard3 = new Card(userJC);
        newCard3.setCreationDate(LocalDateTime.now());
        cardRepository.save(newCard3);
    }
}
