package fr.simplon.api.Controllers;

import fr.simplon.api.Message.CreateCardmessage;
import fr.simplon.api.Message.CreateLineMessage;
import fr.simplon.api.Models.Card;
import fr.simplon.api.Models.Line;
import fr.simplon.api.Models.Product;
import fr.simplon.api.Models.User;
import fr.simplon.api.Repositoy.CardRepository;
import fr.simplon.api.Repositoy.LineRepository;
import fr.simplon.api.Repositoy.ProductRepository;
import fr.simplon.api.Repositoy.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/card/")
public class CardController {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final LineRepository lineRepository;



    public CardController(CardRepository cardRepository, UserRepository userRepository, ProductRepository productRepository,LineRepository lineRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.lineRepository = lineRepository;
    }

    @PostMapping("/")
    public Card createCard( @RequestBody CreateCardmessage card ) throws Exception {

        User user = userRepository.findById(card.getUser()).orElseThrow(()->new Exception("User not found"));

        Card newCard = new Card();

        newCard.setUser(user);
        newCard.setCreationDate(LocalDateTime.now());

        return cardRepository.save((newCard));
    }

    @PostMapping  ("/add")
    public Card insertCard(@RequestBody CreateLineMessage line) throws Exception {

        // recherche de la card correspondante
        Card card = cardRepository.findById(line.getCard()).orElseThrow(()->new Exception("Card not found"));

        // ajout de line dans la list de  Line
        Line newLine = new Line();

        newLine.setQuantity(line.getQuantity());

        Product product = productRepository.findById(line.getProduct()).orElseThrow(()->new Exception("Product not found"));

        newLine.setProduct(product);

        lineRepository.save(newLine);

        List<Line> lines = card.getLines();
        lines.add(newLine);

        return cardRepository.save((card));
    }


}
