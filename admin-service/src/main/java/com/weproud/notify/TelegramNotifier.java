package com.weproud.notify;

import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Logan. k
 */

@Slf4j
@Data
public class TelegramNotifier extends AbstractStatusChangeNotifier {
    private static final String DEFAULT_MESSAGE = "[#{application.id}][#{application.name}] is '#{to.status}'";

    private final SpelExpressionParser parser = new SpelExpressionParser();
    private RestTemplate restTemplate = new RestTemplate();

    private String apiUrl = "https://api.telegram.org/bot%s/sendMessage";
    ;
    private String botToken;
    private String chatId;

    private Expression message;

    public TelegramNotifier() {
        this.message = parser.parseExpression(DEFAULT_MESSAGE, ParserContext.TEMPLATE_EXPRESSION);
    }

    @Override
    protected void doNotify(final ClientApplicationEvent event) throws Exception {
        restTemplate.postForEntity(String.format(this.apiUrl, this.botToken), createMessage(event), Void.class);
    }

    protected HttpEntity<Map<String, Object>> createMessage(ClientApplicationEvent event) {
        Map<String, Object> body = new HashMap<>();
        body.put("chat_id", this.chatId);
        body.put("text", getText(event));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

    protected String getText(ClientApplicationEvent event) {
        return message.getValue(event, String.class);
    }

}
