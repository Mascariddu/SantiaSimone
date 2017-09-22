/**
 * Sample Skeleton for 'Timetable.fxml' Controller Class
 */

package it.polito.tdp.timetable.panel;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.timetable.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Timetable {
	
	private Model model;
	private Label[][] labelMap = new Label[8][7];

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tbTimetable"
    private BorderPane tbTimetable; // Value injected by FXMLLoader

    @FXML // fx:id="lbl1"
    private Label lbl1; // Value injected by FXMLLoader

    @FXML // fx:id="lbl2"
    private Label lbl2; // Value injected by FXMLLoader

    @FXML // fx:id="lbl3"
    private Label lbl3; // Value injected by FXMLLoader

    @FXML // fx:id="lbl4"
    private Label lbl4; // Value injected by FXMLLoader

    @FXML // fx:id="lbl5"
    private Label lbl5; // Value injected by FXMLLoader

    @FXML // fx:id="lbl6"
    private Label lbl6; // Value injected by FXMLLoader

    @FXML // fx:id="lbl7"
    private Label lbl7; // Value injected by FXMLLoader

    @FXML // fx:id="lbl8"
    private Label lbl8; // Value injected by FXMLLoader

    @FXML // fx:id="lbl11"
    private Label lbl11; // Value injected by FXMLLoader

    @FXML // fx:id="lbl12"
    private Label lbl12; // Value injected by FXMLLoader

    @FXML // fx:id="lbl13"
    private Label lbl13; // Value injected by FXMLLoader

    @FXML // fx:id="lbl21"
    private Label lbl21; // Value injected by FXMLLoader

    @FXML // fx:id="lbl22"
    private Label lbl22; // Value injected by FXMLLoader

    @FXML // fx:id="lbl32"
    private Label lbl32; // Value injected by FXMLLoader

    @FXML // fx:id="lbl31"
    private Label lbl31; // Value injected by FXMLLoader

    @FXML // fx:id="lbl42"
    private Label lbl42; // Value injected by FXMLLoader

    @FXML // fx:id="lbl52"
    private Label lbl52; // Value injected by FXMLLoader

    @FXML // fx:id="lbl62"
    private Label lbl62; // Value injected by FXMLLoader

    @FXML // fx:id="lbl72"
    private Label lbl72; // Value injected by FXMLLoader

    @FXML // fx:id="lbl82"
    private Label lbl82; // Value injected by FXMLLoader

    @FXML // fx:id="lbl41"
    private Label lbl41; // Value injected by FXMLLoader

    @FXML // fx:id="lbl51"
    private Label lbl51; // Value injected by FXMLLoader

    @FXML // fx:id="lbl61"
    private Label lbl61; // Value injected by FXMLLoader

    @FXML // fx:id="lbl71"
    private Label lbl71; // Value injected by FXMLLoader

    @FXML // fx:id="lbl81"
    private Label lbl81; // Value injected by FXMLLoader

    @FXML // fx:id="lbl23"
    private Label lbl23; // Value injected by FXMLLoader

    @FXML // fx:id="lbl33"
    private Label lbl33; // Value injected by FXMLLoader

    @FXML // fx:id="lbl43"
    private Label lbl43; // Value injected by FXMLLoader

    @FXML // fx:id="lbl53"
    private Label lbl53; // Value injected by FXMLLoader

    @FXML // fx:id="lbl63"
    private Label lbl63; // Value injected by FXMLLoader

    @FXML // fx:id="lbl73"
    private Label lbl73; // Value injected by FXMLLoader

    @FXML // fx:id="lbl83"
    private Label lbl83; // Value injected by FXMLLoader

    @FXML // fx:id="lbl14"
    private Label lbl14; // Value injected by FXMLLoader

    @FXML // fx:id="lbl24"
    private Label lbl24; // Value injected by FXMLLoader

    @FXML // fx:id="lbl34"
    private Label lbl34; // Value injected by FXMLLoader

    @FXML // fx:id="lbl44"
    private Label lbl44; // Value injected by FXMLLoader

    @FXML // fx:id="lbl54"
    private Label lbl54; // Value injected by FXMLLoader

    @FXML // fx:id="lbl64"
    private Label lbl64; // Value injected by FXMLLoader

    @FXML // fx:id="lbl74"
    private Label lbl74; // Value injected by FXMLLoader

    @FXML // fx:id="lbl84"
    private Label lbl84; // Value injected by FXMLLoader

    @FXML // fx:id="lbl16"
    private Label lbl16; // Value injected by FXMLLoader

    @FXML // fx:id="lbl26"
    private Label lbl26; // Value injected by FXMLLoader

    @FXML // fx:id="lbl36"
    private Label lbl36; // Value injected by FXMLLoader

    @FXML // fx:id="lbl46"
    private Label lbl46; // Value injected by FXMLLoader

    @FXML // fx:id="lbl56"
    private Label lbl56; // Value injected by FXMLLoader

    @FXML // fx:id="lbl66"
    private Label lbl66; // Value injected by FXMLLoader

    @FXML // fx:id="lbl76"
    private Label lbl76; // Value injected by FXMLLoader

    @FXML // fx:id="lbl86"
    private Label lbl86; // Value injected by FXMLLoader

    @FXML // fx:id="lbl25"
    private Label lbl25; // Value injected by FXMLLoader

    @FXML // fx:id="lbl15"
    private Label lbl15; // Value injected by FXMLLoader

    @FXML // fx:id="lbl35"
    private Label lbl35; // Value injected by FXMLLoader

    @FXML // fx:id="lbl45"
    private Label lbl45; // Value injected by FXMLLoader

    @FXML // fx:id="lbl55"
    private Label lbl55; // Value injected by FXMLLoader

    @FXML // fx:id="lbl65"
    private Label lbl65; // Value injected by FXMLLoader

    @FXML // fx:id="lbl75"
    private Label lbl75; // Value injected by FXMLLoader

    @FXML // fx:id="lbl85"
    private Label lbl85; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tbTimetable != null : "fx:id=\"tbTimetable\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl4 != null : "fx:id=\"lbl4\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl5 != null : "fx:id=\"lbl5\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl6 != null : "fx:id=\"lbl6\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl7 != null : "fx:id=\"lbl7\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl8 != null : "fx:id=\"lbl8\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl11 != null : "fx:id=\"lbl11\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl12 != null : "fx:id=\"lbl12\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl13 != null : "fx:id=\"lbl13\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl21 != null : "fx:id=\"lbl21\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl22 != null : "fx:id=\"lbl22\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl32 != null : "fx:id=\"lbl32\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl31 != null : "fx:id=\"lbl31\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl42 != null : "fx:id=\"lbl42\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl52 != null : "fx:id=\"lbl52\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl62 != null : "fx:id=\"lbl62\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl72 != null : "fx:id=\"lbl72\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl82 != null : "fx:id=\"lbl82\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl41 != null : "fx:id=\"lbl41\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl51 != null : "fx:id=\"lbl51\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl61 != null : "fx:id=\"lbl61\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl71 != null : "fx:id=\"lbl71\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl81 != null : "fx:id=\"lbl81\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl23 != null : "fx:id=\"lbl23\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl33 != null : "fx:id=\"lbl33\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl43 != null : "fx:id=\"lbl43\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl53 != null : "fx:id=\"lbl53\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl63 != null : "fx:id=\"lbl63\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl73 != null : "fx:id=\"lbl73\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl83 != null : "fx:id=\"lbl83\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl14 != null : "fx:id=\"lbl14\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl24 != null : "fx:id=\"lbl24\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl34 != null : "fx:id=\"lbl34\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl44 != null : "fx:id=\"lbl44\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl54 != null : "fx:id=\"lbl54\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl64 != null : "fx:id=\"lbl64\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl74 != null : "fx:id=\"lbl74\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl84 != null : "fx:id=\"lbl84\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl16 != null : "fx:id=\"lbl16\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl26 != null : "fx:id=\"lbl26\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl36 != null : "fx:id=\"lbl36\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl46 != null : "fx:id=\"lbl46\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl56 != null : "fx:id=\"lbl56\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl66 != null : "fx:id=\"lbl66\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl76 != null : "fx:id=\"lbl76\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl86 != null : "fx:id=\"lbl86\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl25 != null : "fx:id=\"lbl25\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl15 != null : "fx:id=\"lbl15\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl35 != null : "fx:id=\"lbl35\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl45 != null : "fx:id=\"lbl45\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl55 != null : "fx:id=\"lbl55\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl65 != null : "fx:id=\"lbl65\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl75 != null : "fx:id=\"lbl75\" was not injected: check your FXML file 'Timetable.fxml'.";
        assert lbl85 != null : "fx:id=\"lbl85\" was not injected: check your FXML file 'Timetable.fxml'.";
        
        labelMap[0][0] = lbl1;
        labelMap[1][0] = lbl2;
        labelMap[2][0] = lbl3;
        labelMap[3][0] = lbl4;
        labelMap[4][0] = lbl5;
        labelMap[5][0] = lbl6;
        labelMap[6][0] = lbl7;
        labelMap[7][0] = lbl8;
        
        labelMap[0][1] = lbl11;
        labelMap[1][1] = lbl21;
        labelMap[2][1] = lbl31;
        labelMap[3][1] = lbl41;
        labelMap[4][1] = lbl51;
        labelMap[5][1] = lbl61;
        labelMap[6][1] = lbl71;
        labelMap[7][1] = lbl81;
        
        labelMap[0][2] = lbl12;
        labelMap[1][2] = lbl22;
        labelMap[2][2] = lbl32;
        labelMap[3][2] = lbl42;
        labelMap[4][2] = lbl52;
        labelMap[5][2] = lbl62;
        labelMap[6][2] = lbl72;
        labelMap[7][2] = lbl82;
        
        labelMap[0][3] = lbl13;
        labelMap[1][3] = lbl23;
        labelMap[2][3] = lbl33;
        labelMap[3][3] = lbl43;
        labelMap[4][3] = lbl53;
        labelMap[5][3] = lbl63;
        labelMap[6][3] = lbl73;
        labelMap[7][3] = lbl83;
        
        labelMap[0][4] = lbl14;
        labelMap[1][4] = lbl24;
        labelMap[2][4] = lbl34;
        labelMap[3][4] = lbl44;
        labelMap[4][4] = lbl54;
        labelMap[5][4] = lbl64;
        labelMap[6][4] = lbl74;
        labelMap[7][4] = lbl84;
        
        labelMap[0][5] = lbl15;
        labelMap[1][5] = lbl25;
        labelMap[2][5] = lbl35;
        labelMap[3][5] = lbl45;
        labelMap[4][5] = lbl55;
        labelMap[5][5] = lbl65;
        labelMap[6][5] = lbl75;
        labelMap[7][5] = lbl85;
        
        labelMap[0][6] = lbl16;
        labelMap[1][6] = lbl26;
        labelMap[2][6] = lbl36;
        labelMap[3][6] = lbl46;
        labelMap[4][6] = lbl56;
        labelMap[5][6] = lbl66;
        labelMap[6][6] = lbl76;
        labelMap[7][6] = lbl86;

    }
    
    public void setModel(Model model, String[][] timetable) {
    	this.model = model;
    	
    	int start = model.getSchool().getStartLessons();
    	for(int r = 0; r <= model.getHoursDaySchool(); r++) {
    		labelMap[r][0].setText(String.valueOf(start) + ":00");
    		start++;
    	}
    		
    	
    	for(int r = 0; r < model.getHoursDaySchool(); r++) {
    		for(int c = 0; c< model.getSchool().getWorkDays(); c++)
    			labelMap[r][c+1].setText(timetable[r][c]);
    	}
    	
    	
    	
    }
    
    
}
