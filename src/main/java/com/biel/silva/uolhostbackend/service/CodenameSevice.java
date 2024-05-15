package com.biel.silva.uolhostbackend.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CodenameSevice {

    private final RestTemplate restTemplate;
    private final org.springframework.core.env.Environment env;

    public CodenameSevice(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    private List<String> avangersCodenamesList = new ArrayList<>();
    private List<String> jusliceLeagueCodenamesList = new ArrayList<>();
    private List<String> teenTitansCodenamesList = new ArrayList<>();
    private List<String> fantasticFourCodenamesList = new ArrayList<>();
    private List<String> xmenCodenamesList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadCodename() throws JsonProcessingException {
        String codename = restTemplate.getForObject(env.getProperty("avangers"), String.class);
        JsonNode jsonNode = objectMapper.readTree(codename);
        ArrayNode avangers = (ArrayNode) jsonNode.get("vingadores");

        for (JsonNode avanger : avangers) {
            avangersCodenamesList.add(avanger.get("codinome").asText());
        }



    }

    @PostConstruct
    public void loadxmlData(){

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(env.getProperty("justice.league"));

            NodeList nodeList = doc.getElementsByTagName("codinome");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element codename = (Element) nodeList.item(i);
                String codenameValue = codename.getTextContent();
                jusliceLeagueCodenamesList.add(codenameValue);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadTitansCodenames() {
        teenTitansCodenamesList.add("Robin");
        teenTitansCodenamesList.add("Raven");
        teenTitansCodenamesList.add("Starfire");
        teenTitansCodenamesList.add("Mutano");
        teenTitansCodenamesList.add("Ciborgue");
    }

    @PostConstruct
    public void loadFantasticFourCodenames() {
        fantasticFourCodenamesList.add("Sr. Fantástico");
        fantasticFourCodenamesList.add("Mulher Invisível");
        fantasticFourCodenamesList.add("Tocha Humana");
        fantasticFourCodenamesList.add("Coisa");
    }

    @PostConstruct
    public void loadXmenCodenames() {
        xmenCodenamesList.add("Ciclope");
        xmenCodenamesList.add("Jean Grey");
        xmenCodenamesList.add("Fera");
        xmenCodenamesList.add("Wolverine");
        xmenCodenamesList.add("Tempestade");
    }


}
