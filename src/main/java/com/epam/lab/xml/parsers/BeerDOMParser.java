package com.epam.lab.xml.parsers;

import com.epam.lab.xml.models.Beer;
import com.epam.lab.xml.models.Chars;
import com.epam.lab.xml.models.PouringMethod;
import com.epam.lab.xml.models.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BeerDOMParser {

    private Document document;

    public BeerDOMParser(String path) {
        document = getDocument(path);
    }

    private Document getDocument(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = Objects.requireNonNull(builder).parse(path);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public List<Beer> parseXML() {
        document.getDocumentElement().normalize();
        List<Beer> beerList = new ArrayList<>();
        NodeList nodeList = document.getElementsByTagName("beer");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Beer beer = new Beer();
            PouringMethod pouringMethod;
            Chars chars;
            List<String> ingredients = new ArrayList<>();
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                beer.setId(Integer.parseInt(element.getAttribute("beerId")));
                beer.setName(element.getElementsByTagName("name").item(0).getTextContent());
                beer.setType(Type.valueOf(element.getElementsByTagName("type").item(0).getTextContent()));
                beer.setType(Type.valueOf(element.getElementsByTagName("type").item(0).getTextContent()));
                beer.setAi(Boolean.parseBoolean(element.getElementsByTagName("AI").item(0).getTextContent()));
                beer.setManufacturer(element.getElementsByTagName("manufacturer").item(0).getTextContent());
                chars = parseChars(element.getElementsByTagName("chars"));
                NodeList nodeListIngridients = document.getElementsByTagName("ingredients");
                for (int j = 0; j <= nodeListIngridients.getLength(); j++) {
                    ingredients.add(element.getElementsByTagName("ingredient").item(j).getTextContent());
                }
                beer.setChars(chars);
                beer.setIngredients(ingredients);
                beerList.add(beer);
            }
        }
        return beerList;
    }

    private Chars parseChars(NodeList node) {
        Chars chars = new Chars();
        if (node.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node.item(0);
            chars.setAlcoholVolume(Double.parseDouble(element.getElementsByTagName("alcoholVolume").item(0).getTextContent()));
            chars.setTransparency(Double.parseDouble(element.getElementsByTagName("transparency").item(0).getTextContent()));
            chars.setFoodValue(Double.parseDouble(element.getElementsByTagName("foodValue").item(0).getTextContent()));
            chars.setFilter(Boolean.parseBoolean(element.getElementsByTagName("filter").item(0).getTextContent()));
            chars.setPouringMethod(parsePouringMethod(document.getElementsByTagName("pouringMethod"), 0));
        }

        return chars;
    }

    private PouringMethod parsePouringMethod(NodeList node, int counter) {
        PouringMethod pouringMethod = new PouringMethod();
        if (node.item(counter).getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node.item(counter);
            pouringMethod.setMaterial(element.getElementsByTagName("material").
                    item(0).getTextContent());
            pouringMethod.setVolume(Double.parseDouble(element.getElementsByTagName("volume").
                    item(0).getTextContent()));
        }
        return pouringMethod;
    }

}
