package ca.sheridancollege.khaalize.beans;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Income {
    private Long id;
    private Long amount;
}
