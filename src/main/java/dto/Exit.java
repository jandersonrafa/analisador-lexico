package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.StateType;
import services.TokenType;

import java.util.Map;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exit {

    private TokenType tokenType;

    private Integer line;

    private Integer symbolId;

}
