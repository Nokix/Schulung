package de.schulung.Schulung.rest;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@RestController
public class HalloController {
    final Faker faker;

    @GetMapping("/hallo")
    public String sayHello() {
        return "Hallo " + faker.name().fullName();
    }

    @GetMapping("/byebye/{name}")
    public String sayBye(@PathVariable(name = "name") String str) {
        return "Goodbye "+ str;
    }

    // localhost:8080/count?start=10&n=15
    // 10 11 12 13 14 15
    //
    // localhost:8080/count?n=20
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    // SpEL: Spring Expression Language
    @GetMapping("/count")
    public String countUp(@RequestParam(defaultValue = "1") Integer start,
                          @RequestParam(name = "${HalloController.end}") Integer end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
    }
}
