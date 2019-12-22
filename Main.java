package application;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	private double prefWidth = 500.0;
	private double prefHeight = 600.0;
	private AnchorPane Mmenu, Gscreen, Cscreen, GOscreen, Sscreen;
	private Button Start,B0,B1,B2,B3,Back,Save, NextLevel, Savefinder;
	private Component Open, SaveOpen;
	private Font startbutton;
	private Font Glevel = new Font("Yu Gothic Bold",65.0);
	private Font GRaB = new Font("Calibri Bold",25.0);
	private Font Mtext;
	private Text Mname,GlevelText,GoverText, EnterNameText, BeginText;
	private TextField Loadfield, Namefield;
	private Scene mainmenu, gamescreen, colourscreen;
	private Group Gbuttons, Colours;
	private int level, cinput, place, checker;
	private ArrayList<Integer> colororder;
	private Background x;
	private Desktop desktop;
	private Rectangle C0,C1,C2,C3;
	private double PrefButtonWidth = 175.0;
	private double PrefButtonHeight = 100.0;
	private TimeUnit t;
	private String Name;

	
	public void start(Stage primaryStage) {
		try {
			x = new Background();
			colororder = new ArrayList<Integer>();
			B0 = new Button("0"); //green
			B1 = new Button("1"); //red
			B2 = new Button("2"); //yellow
			B3 = new Button("3"); //blue
			Back = new Button("BACK");
			Save = new Button("SAVE");
			Namefield = new TextField();

			
				
			DefaultSettings();
			MainMenu();
			colourscreen = ColourReveal(1);
	
			Start.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					primaryStage.setScene(StartScreen());
					//NextLevel(primaryStage);
				}
			});
			
			Start.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			            Start.setStyle("-fx-background-color: crimson");
			          }
			        });

			Start.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			      		Start.setStyle("-fx-background-color: #E53935");
			          }
			        });
			
			Savefinder.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					JFileChooser load = new JFileChooser();
					load.setDialogTitle("Select Save File");
					load.setCurrentDirectory(new File(System.getProperty("user.dir")));
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "Text File", "txt");
				    load.setFileFilter(filter);
				    int returnVal = load.showOpenDialog(Open);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       Loadfield.setText(load.getCurrentDirectory() + "\\" + 
				    load.getSelectedFile().getName());
				    }
				}
				
			});
			
			B0.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					cinput = 0;
					checker = x.Checker(colororder, place, cinput);
					place++;
					ColourChecker(checker, primaryStage);
					}
			});
			
			
			B0.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			            B0.setStyle("-fx-background-color: #33691E");
			          }
			        });

			B0.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			      		B0.setStyle("-fx-background-color: #7CB342");
			          }
			        });
			
			B1.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			            B1.setStyle("-fx-background-color: #B71C1C");
			          }
			        });

			B1.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			      		B1.setStyle("-fx-background-color: #E53935");
			          }
			        });
			
			B2.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			            B2.setStyle("-fx-background-color: #FF6F00");
			          }
			        });

			B2.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			      		B2.setStyle("-fx-background-color: #FFC107");
			          }
			        });
			
			B3.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			            B3.setStyle("-fx-background-color: #0D47A1");
			          }
			        });

			B3.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			      		B3.setStyle("-fx-background-color: #1E88E5");
			          }
			        });
			
			B1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					cinput = 1;
					checker = x.Checker(colororder, place, cinput);
					place++;
					ColourChecker(checker, primaryStage);
					}
			});
			
			B2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					cinput = 2;
					checker = x.Checker(colororder, place, cinput);
					place++;
					ColourChecker(checker, primaryStage);
					}
				});
			
			B3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					cinput = 3;
					checker = x.Checker(colororder, place, cinput);
					place++;
					ColourChecker(checker, primaryStage);
					}
			});
			
			Back.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					DefaultSettings();
					primaryStage.setScene(mainmenu);
					primaryStage.show();
					
				}
				
			});
			
			Back.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			            Back.setStyle("-fx-background-color: #B71C1C");
			          }
			        });

			Back.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          public void handle(MouseEvent e) {
			      		Back.setStyle("-fx-background-color: red");
			          }
			        });
			
			Namefield.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					 if (event.getCode().equals(KeyCode.ENTER))
			            {
			              NextLevel(primaryStage);
			              Name = Namefield.getText();
			              System.out.println(Name);
			            }					
				}
				
			});
			
			Save.setOnAction(new EventHandler<ActionEvent>( ) {
				public void handle(ActionEvent arg0) {
					JFileChooser savefile = new JFileChooser();
					
					File output = new File("SimonSave.txt");
						
					try {
						PrintWriter print = new PrintWriter(output);
						print.write(Name + "," + level);
						print.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					
					
					savefile.setDialogTitle("Save File");
					savefile.setCurrentDirectory(new File(System.getProperty("user.dir")));
					int returnVal = savefile.showSaveDialog(SaveOpen);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       System.out.println("one"); 
				    
				    }
				}
				
			});
			
			
			primaryStage.setTitle("SIMON");
			primaryStage.setScene(mainmenu);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	private Scene GameOver(int level) {
		GOscreen = new AnchorPane();
		GoverText = new Text();
		
		Back.setText("BACK TO MENU");
		Back.setLayoutX(101.0);
		Back.setLayoutY(399.0);
		Back.setPrefWidth(300.0);
		
		GoverText.setTextAlignment(TextAlignment.CENTER);
		GoverText.setText("YOU GOT TO " + '\n' + "LEVEL " + level);
		GoverText.setFont(Glevel);
		GoverText.setLayoutX(45.0);
		GoverText.setLayoutY(177.0);
		
		GOscreen.getChildren().addAll(Back, GoverText);
		
		return new Scene (GOscreen, prefWidth, prefHeight, Color.IVORY);
		
	}
	 
	private Scene StartScreen() {
		Sscreen = new AnchorPane();
		EnterNameText = new Text();
		BeginText = new Text();
		Font EnterFont = new Font("Yu Gothic UI Bold", 25.0);
		
		EnterNameText.setLayoutX(30.0);
		EnterNameText.setLayoutY(138.0);
		EnterNameText.setText("ENTER NAME" + '\n' + "TO BEGIN");
		EnterNameText.setTextAlignment(TextAlignment.CENTER);
		EnterNameText.setFont(Glevel);
		
		BeginText.setLayoutX(142.0);
		BeginText.setLayoutY(427.0);
		BeginText.setText("Press Enter to Start");
		BeginText.setTextAlignment(TextAlignment.CENTER);
		BeginText.setFont(EnterFont);
		
		Namefield.setLayoutX(101.0);
		Namefield.setLayoutY(327.0);
		Namefield.setPrefSize(300.0, 60.0);
		Namefield.setPromptText("Type Here");
		Namefield.setText("Player");
		Namefield.setFont(EnterFont);
		
		Back.setLayoutX(101.0);
		Back.setLayoutY(495.0);
		Back.setPrefWidth(300.0);
		Back.setFont(GRaB);
		Back.setStyle("-fx-background-color: red");
		Back.setTextFill(Color.WHITE);
		
		Sscreen.getChildren().addAll(EnterNameText, BeginText, Namefield, Back);
		
		return new Scene(Sscreen, prefWidth, prefHeight, Color.IVORY);
		
	}
	
	private void MainMenu() {
		Mmenu = new AnchorPane();
		Start = new Button();
		startbutton = new Font("Arial Black" ,39.0);
		Mtext = new Font("Yu Gothic Bold", 85.0);
		Mname = new Text();
		Loadfield = new TextField();
		Savefinder = new Button();
		
		Mmenu.getChildren().clear();
		
		Mmenu.setPrefSize(prefWidth, prefHeight);
		
		Start.setLayoutX(150.0);
		Start.setLayoutY(412.0);
		Start.setPrefSize(200.0, 100.0);
		Start.setStyle("-fx-background-color: Crimson");
		Start.setText("START");
		Start.setTextFill(Color.WHITE);
		Start.setWrapText(true);
		Start.setFont(startbutton);
		
		Savefinder.setText("Browse");
		Savefinder.setStyle("-fx-background-color: Aqua");
		Savefinder.setPrefSize(100.0, 25.0);
		Savefinder.setLayoutX(200.0);
		Savefinder.setLayoutY(372.0);
		
		Mname.setLayoutX(102.0);
		Mname.setLayoutY(127.0);
		Mname.setText("SIMON");
		Mname.setTextAlignment(TextAlignment.CENTER);
		Mname.setFont(Mtext);
		
		Loadfield.setLayoutX(136.0);
		Loadfield.setLayoutY(337.0);
		Loadfield.setPrefSize(228.0, 35.0);
		Loadfield.setPromptText("Type Save File Directory");
		
		Mmenu.getChildren().addAll(Start,Mname,Loadfield,Savefinder);
		
		mainmenu = new Scene(Mmenu,prefWidth,prefHeight,Color.IVORY);
	}
	
	private Scene GameScreen(int level) {
		Gscreen = new AnchorPane();
		Gbuttons = new Group();
		GlevelText = new Text();
		
		Gscreen.setPrefSize(prefWidth, prefHeight);
		
		B0.setPrefSize(PrefButtonWidth, PrefButtonHeight);
		B0.setLayoutX(75.0);
		B0.setLayoutY(234.0);
		B0.setStyle("-fx-background-color: #7CB342");
		
		B1.setPrefSize(PrefButtonWidth, PrefButtonHeight);
		B1.setLayoutX(250.0);
		B1.setLayoutY(234.0);
		B1.setStyle("-fx-background-color: #E53935");
		
		B2.setPrefSize(PrefButtonWidth, PrefButtonHeight);
		B2.setLayoutX(75.0);
		B2.setLayoutY(334.0);
		B2.setStyle("-fx-background-color: #FFC107");
		
		B3.setPrefSize(PrefButtonWidth, PrefButtonHeight);
		B3.setLayoutX(250.0);
		B3.setLayoutY(334.0);
		B3.setStyle("-fx-background-color: #1E88E5");
		
		GlevelText.setLayoutX(142.0);
		GlevelText.setLayoutY(137.0);
		GlevelText.setText("Level " + level);
		GlevelText.setFont(Glevel);
		
		Back.setPrefSize(120.0,60.0);
		Back.setLayoutX(53.0);
		Back.setLayoutY(485.0);
		Back.setStyle("-fx-background-color: red");
		Back.setTextFill(Color.WHITE);
		Back.setFont(GRaB);
		
		Save.setPrefSize(110.0, 60.0);
		Save.setLayoutX(338.0);
		Save.setLayoutY(485.0);
		Save.setStyle("-fx-background-color: green");
		Save.setTextFill(Color.WHITE);
		Save.setFont(GRaB);
		
		Gbuttons.getChildren().addAll(B0,B1,B2,B3);
		Gscreen.getChildren().addAll(Gbuttons,Back,Save,GlevelText);
		
		return gamescreen = new Scene(Gscreen,prefWidth,prefHeight,Color.IVORY);
		
	}
	
	private Scene ColourReveal(int level) {
		Cscreen = new AnchorPane();
		Colours = new Group();
		GlevelText = new Text();
		C0 = new Rectangle(); //GREEN
		C1 = new Rectangle(); //RED
		C2 = new Rectangle(); //YELLOW
		C3 = new Rectangle(); //BLUE
		
		C0.setArcHeight(0);
		C0.setArcWidth(0);
		C0.setHeight(PrefButtonHeight);
		C0.setWidth(PrefButtonWidth);
		C0.setLayoutX(75.0);
		C0.setLayoutY(234.0);
		C0.setStrokeWidth(0);
		C0.setFill(Color.LIMEGREEN);
		
		C1.setArcHeight(0);
		C1.setArcWidth(0);
		C1.setHeight(PrefButtonHeight);
		C1.setWidth(PrefButtonWidth);
		C1.setLayoutX(250.0);
		C1.setLayoutY(235.0);
		C1.setStrokeWidth(0);
		C1.setFill(Color.CRIMSON);
		
		C2.setArcHeight(0);
		C2.setArcWidth(0);
		C2.setHeight(PrefButtonHeight);
		C2.setWidth(PrefButtonWidth);
		C2.setLayoutX(75.0);
		C2.setLayoutY(334.0);
		C2.setStrokeWidth(0);
		C2.setFill(Color.YELLOW);
		
		C3.setArcHeight(0);
		C3.setArcWidth(0);
		C3.setHeight(PrefButtonHeight);
		C3.setWidth(PrefButtonWidth);
		C3.setLayoutX(250.0);
		C3.setLayoutY(334.0);
		C3.setStrokeWidth(0);
		C3.setFill(Color.BLUE);
		
		GlevelText.setLayoutX(142.0);
		GlevelText.setLayoutY(137.0);
		GlevelText.setText("Level " + level);
		GlevelText.setFont(Glevel);
		
		Colours.getChildren().addAll(C0,C1,C2,C3);
		Cscreen.getChildren().addAll(Colours, GlevelText);
		
		return colourscreen = new Scene(Cscreen, prefWidth, prefHeight, Color.IVORY);
	
	}
	
	private void NextLevel(Stage primaryStage) {
		level++;
		colororder.clear();
		place = 0;
		cinput = -1;
		checker = -1;
		gamescreen = GameScreen(level);
		colourscreen = ColourReveal(level);
		colororder = x.getOrder(level);
		primaryStage.setScene(gamescreen);
		//NextLevelColours(primaryStage);
	}
	
	/*private void NextLevelColours(Stage primaryStage) {
		primaryStage.setScene(colourscreen);
		for (int i = 0; i < colororder.size(); i++) {
			upDate(i);
		}
		
	}*/


		private void upDate(int i) {
			if (colororder.get(i) == (0)) {
				C0.setFill(Color.rgb(172, 255, 185));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					C0.setFill(Color.rgb(124, 179, 66));

			}
			if (colororder.get(i) == (1)) {
				C1.setFill(Color.rgb(239, 154, 154));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				C1.setFill(Color.rgb(229, 57, 53));

			}
			if (colororder.get(i) == (2)) {
				C2.setFill(Color.rgb(255, 213, 79));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				C2.setFill(Color.rgb(255, 193, 7));

			}
			if (colororder.get(i) == (3)) {
				C3.setFill(Color.rgb(129, 212, 250));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				C3.setFill(Color.rgb(30, 136, 229));

			}
		}			
	
	private void DefaultSettings() {
		level = 0;
		colororder.clear();
		place = 0;
		cinput = -1;
		checker = -1;
	}
	
	
	private void ColourChecker(int i, Stage primaryStage) {
		if (i == 0) {
			System.out.println("gameover");
			primaryStage.setScene(GameOver(level));
		}
		if (i == 1) {
			System.out.println("next");
		}
		if (i == 2) {
			System.out.println("next level");
			NextLevel(primaryStage);
		}				
	}
	
	public static void main(String[] args) {
		launch(args);

	}
	
}
