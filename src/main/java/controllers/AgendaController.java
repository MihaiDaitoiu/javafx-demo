package main.java.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.java.models.Abonat;
import main.java.models.Adresa;
import main.java.service.AgendaService;
import main.java.service.AgendaServiceImpl;

import java.util.List;

public class AgendaController {

    //normally done with dependency injection
    private AgendaService agendaService = new AgendaServiceImpl();

    //abonati table area
    @FXML
    private TableView<Abonat> abonatiTableView;
    @FXML
    private TableColumn<Abonat, String> taraTableColumn;
    @FXML
    private TableColumn<Abonat, String> orasTableColumn;
    @FXML
    private TableColumn<Abonat, String> stradaTableColumn;

    //delete abonat area
    @FXML
    private Button deleteAbonatButton;

    //add abonat area
    @FXML
    private TextField numeTextField;
    @FXML
    private TextField prenumeTextField;
    @FXML
    private TextField taraTextField;
    @FXML
    private TextField orasTextField;
    @FXML
    private TextField stradaTextField;
    @FXML
    private Button addAbonatButton;

    /**
     * Method called automatically by the FXML loader when creating the corresponding view
     * Note the annotation! - it is mandatory in order for the loader to notice this method
     */
    @FXML
    public void initialize() {

        initializeAbonatiTable();

        initializeDeleteButton();

        initializeAddButton();

        reloadAbonati();
    }

    private void initializeAddButton() {
        addAbonatButton.disableProperty().bind(Bindings.isEmpty(numeTextField.textProperty()));
    }

    private void initializeDeleteButton() {
        deleteAbonatButton.disableProperty().bind(Bindings.size(abonatiTableView.getSelectionModel().getSelectedItems()).isEqualTo(0)
                .or(deleteAbonatButton.focusedProperty().not()
                        .and(abonatiTableView.focusedProperty().not())));
    }

    private void initializeAbonatiTable() {
        taraTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresa().getTara()));
        orasTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresa().getOras()));
        stradaTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresa().getStrada()));
    }

    private void reloadAbonati() {
        List<Abonat> abonatiList = agendaService.getAbonati();
        abonatiTableView.setItems(FXCollections.observableList(abonatiList));
        abonatiTableView.refresh();
    }

    @FXML
    public void deleteAbonat() {
        Long id = abonatiTableView.getSelectionModel().getSelectedItem().getId();
        agendaService.removeAbonat(id);
        reloadAbonati();
    }


    public void addAbonat() {
        Abonat abonat = new Abonat(numeTextField.getText(), prenumeTextField.getText(),
                new Adresa(taraTextField.getText(), orasTextField.getText(), stradaTextField.getText()));
        agendaService.createAbonat(abonat);
        reloadAbonati();
    }
}
