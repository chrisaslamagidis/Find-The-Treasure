/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import commands.VerbCommand;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import game.Floor;
import parser.Controller;
import parser.Parser;
import sources.AudioPlayer;
import game.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.ResourceManager;
import resources.SaveData;
import scene.Scenario;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField inputField;
    @FXML
    private TextArea displayField;
    @FXML
    private ProgressBar healthBar;
    @FXML
    private ProgressBar strengthBar;
    @FXML
    private Button inventoryButton;
    @FXML
    private Button mapButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button loadButton;

    ArrayList<String> output;//Used to save messages from a execution.

    Floor floor;
    Player detective;
    Parser parser;
    Controller controller;
    Scenario scenario;
    SaveData savedata;

    @FXML
    private void handleInputAction(ActionEvent event) throws IOException {

        String[] parts = parser.modifyUserInput(inputField.getText().trim().toLowerCase());
        VerbCommand command = controller.findCommand(parts[0]);

        if (command != null) {
            output = command.exec(parts[1], detective);

            output.forEach((printRow) -> {
                displayField.appendText(printRow + "\n");
            });
        } else {
            displayField.appendText("You cannot do that.\n");
        }

        if (strengthBar.getProgress() > 0 && healthBar.getProgress() > 0) {
            strengthBar.setProgress(detective.getPower());
            healthBar.setProgress(detective.getHealth());
        } else {
            displayField.setText("You don't have enough Strength or Health.\nBuy some more by clicking on the Strength or Health bar.");
            inputField.setDisable(true);

        }

        inputField.clear();
    }

    @FXML
    private void handleStrengthBar(MouseEvent event) throws IOException {
        if (strengthBar.getProgress() <= 0) {
            detective.setPower(1.0);
            strengthBar.setProgress(1.0);
            inputField.setDisable(false);

        }

    }

    @FXML
    private void handleHealthBar(MouseEvent event) throws IOException {
        if (healthBar.getProgress() <= 0) {
            detective.setHealth(1.0);
            healthBar.setProgress(1.0);
            inputField.setDisable(false);
        }
    }

    @FXML
    private void handleInventoryClick(ActionEvent event) {
        detective.viewInventory();

    }

    @FXML
    private void handleMapClick(ActionEvent event) throws IOException {

    Parent home_page_parent=FXMLLoader.load(getClass().getResource("FXMLMap.fxml"));
    Scene home_page_scene=new Scene(home_page_parent);
    Stage app_stage= (Stage) (((Node) event.getSource()).getScene().getWindow());
    app_stage.setScene(home_page_scene);
    app_stage.show();
    }

    @FXML
    private void save(ActionEvent event) {

        savedata.save(detective, floor.getRooms());
        try {
            ResourceManager.save(savedata, "1.save");
            System.out.println("Success");

        } catch (Exception e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }
    }

    @FXML
    private void load(ActionEvent event) {
        try {
            SaveData saveData = (SaveData) ResourceManager.load("1.save");

            saveData.load(detective, floor.getRooms());

            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Couldn't load: " + e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.parser = new Parser();
        this.floor = new Floor();
        controller = new Controller();
        scenario = new Scenario();
        savedata = new SaveData();

        floor.setRooms(scenario.fetchRooms());
        scenario.placeContainers();
        scenario.placeInanimates();
        scenario.placeInspirits();
        scenario.createMap();

        detective = new Player("Player", "I'm the Player.", 1, 1, floor.getRooms().get(1));

        File epic = new File("Sources files\\Audio\\bensound-epic.WAV");
        AudioPlayer audio = new AudioPlayer();
        audio.playsound(epic);
    }

}
