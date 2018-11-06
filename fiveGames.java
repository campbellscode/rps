import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class fiveGames {
    @FXML
    private Label lblMatchCount; 
    @FXML
    private Label lblYourScore; 
    @FXML
    private Label lblCpuScore; 
    @FXML
    private Label lblTies; 
    @FXML
    private Label lblResult; 
    @FXML
    private ImageView imgTitle; 
    @FXML
    private ImageView imgHuman; 
    @FXML
    private ImageView imgComputer; 
    @FXML
    private Button btnRock;  
    @FXML
    private Button btnPaper;  
    @FXML
    private Button btnScissors; 
    
    String yourHand = "";
    String yourHandFirstLetter = "";
    String[] computerHand = new String[3];
    int index = 0;
    int numOfMatches;
    int numOfFiveGames = 1;
    int numTies = 0;
    int numYouWin = 0;
    int numComputerWin = 0;
    String theWinner = "";    
    
    Image titleImage = new Image("/image/title.png");
    Image humanImage = new Image("/image/human.png");
    Image computerImage = new Image("/image/computer.png");
    Image winnerImage = new Image("/image/winner-face.png");
    Image loserImage = new Image("/image/loser-face.png");
    Image tieImage = new Image("/image/tie-face.png");        

    public void rockClick() throws InterruptedException            
    {    
        Image img = new Image("/image/rock.png");
        imgHuman.setImage(img);          

        String yourHand = "R";

        index = (int)(Math.random() * 10) % 3; 
        
        if(index == 0)
        {
            computerHand[index] = "R";
            Image computer = new Image("/image/rock.png");
            imgComputer.setImage(computer);
        }
        else if(index == 1)
        {    
            computerHand[index] = "P";
            Image computer = new Image("/image/paper.png");
            imgComputer.setImage(computer);
        }    
        else if(index == 2)        
        {
            computerHand[index] = "S";
            Image computer = new Image("/image/scissors.png");
            imgComputer.setImage(computer);
        }
                         
        if(yourHand.equals(computerHand[index]))
        {    
            numTies++;
            theWinner = "TIE";             
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(tieImage);  
            lblResult.setText("OH BUMMER!!! IT'S A TIE...");
        }
        
        else if(computerHand[index].equals("P"))
        {    
            numComputerWin++;
            theWinner = "COMPUTER";  
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(loserImage);  
            lblResult.setText("YOU ARE THE LA-HOOSER!!!");
        }    
            
        else if(computerHand[index].equals("S"))
        {    
            numYouWin++;
            theWinner = "YOU";             
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(winnerImage);  
            lblResult.setText("YOU ARE THE WINNER!!!");
        }  
        
        switch (numOfFiveGames) {
            case 5:
                Image finalWinnerImage = new Image("/image/winner-face.png");
                Image finalLoserImage = new Image("/image/loser-face.png");
                Image finalTieImage = new Image("/image/tie-face.png");
                
                imgHuman.setVisible(false);
                imgComputer.setVisible(false);
                
                if (numYouWin == numComputerWin)  
                {
                    imgTitle.setImage(finalTieImage);  
                    lblResult.setText("THE GAME IS A DRAW!!!");
                }
                else if (numYouWin > numComputerWin)  
                {
                    imgTitle.setImage(finalWinnerImage);  
                    lblResult.setText("YOU WON THE GAME!!!");
                    playWinMusic("C:\\Users\\kidka\\Documents\\NetBeansProjects\\Final Project\\src\\audio\\flawless-victory.wav");
                    
                }
                else if (numYouWin < numComputerWin)  
                {
                    imgTitle.setImage(finalLoserImage);  
                    lblResult.setText("YOU LOST THE GAME!!!");
                    playWinMusic("C:\\Users\\kidka\\Documents\\NetBeansProjects\\Final Project\\src\\audio\\you-lose.wav");
                }                
                                    
                btnRock.setVisible(false);
                btnPaper.setVisible(false);
                btnScissors.setVisible(false);
                
                numOfFiveGames = 1;
                numTies = 0;
                numYouWin = 0;
                numComputerWin = 0;                 

                break;                
            default:
                lblMatchCount.setText("GAME  " + numOfFiveGames + " / 5");
                numOfFiveGames = numOfFiveGames + 1;
                break;                
        }
    }
    
        public void paperClick() throws InterruptedException
    {   
        Image img = new Image("/image/paper.png");
        imgHuman.setImage(img);          

        String yourHand = "P";

        index = (int)(Math.random() * 10) % 3; 
        
        if(index == 0)
        {
            computerHand[index] = "R";
            Image computer = new Image("/image/rock.png");
            imgComputer.setImage(computer);
        }
        else if(index == 1)
        {    
            computerHand[index] = "P";
            Image computer = new Image("/image/paper.png");
            imgComputer.setImage(computer);
        }    
        else if(index == 2)        
        {
            computerHand[index] = "S";
            Image computer = new Image("/image/scissors.png");
            imgComputer.setImage(computer);
        }
                         
        if(yourHand.equals(computerHand[index]))
        {    
            numTies++;
            theWinner = "TIE"; 
            Image tieImage = new Image("/image/tie-face.png");
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(tieImage);  
            lblResult.setText("OH BUMMER!!! IT'S A TIE...");
        }
        
        else if(computerHand[index].equals("S"))
        {    
            numComputerWin++;
            theWinner = "COMPUTER";  
            Image loserImage = new Image("/image/loser-face.png");
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(loserImage);  
            lblResult.setText("YOU ARE A LA-HOOSER!!!");
        }    
            
        else if(computerHand[index].equals("R"))
        {    
            numYouWin++;
            theWinner = "YOU";  
            Image winnerImage = new Image("/image/winner-face.png");
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(winnerImage);  
            lblResult.setText("YOU ARE THE WINNER!!!");
        }      
        
        switch (numOfFiveGames) {
            case 5:
                Image finalWinnerImage = new Image("/image/winner-face.png");
                Image finalLoserImage = new Image("/image/loser-face.png");
                Image finalTieImage = new Image("/image/tie-face.png");

                imgHuman.setVisible(false);
                imgComputer.setVisible(false);
                
                if (numYouWin == numComputerWin)  
                {
                    imgTitle.setImage(finalTieImage); 
                    lblResult.setText("THE GAME IS A DRAW!!!");
                }
                else if (numYouWin > numComputerWin)  
                {
                    imgTitle.setImage(finalWinnerImage);  
                    lblResult.setText("YOU WON THE GAME!!!");
                    playWinMusic("C:\\Users\\kidka\\Documents\\NetBeansProjects\\Final Project\\src\\audio\\flawless-victory.wav");
                }
                else if (numYouWin < numComputerWin)  
                {
                    imgTitle.setImage(finalLoserImage);  
                    lblResult.setText("YOU LOST THE GAME!!!");
                    playWinMusic("C:\\Users\\kidka\\Documents\\NetBeansProjects\\Final Project\\src\\audio\\you-lose.wav");
                }                
                                    
                btnRock.setVisible(false);
                btnPaper.setVisible(false);
                btnScissors.setVisible(false);
                
                numOfFiveGames = 1;
                numTies = 0;
                numYouWin = 0;
                numComputerWin = 0;                 

                break;                
            default:
                lblMatchCount.setText("GAME  " + numOfFiveGames + " / 5");
                numOfFiveGames = numOfFiveGames + 1;
                break;                
        }
    }
        
    public void scissorsClick() throws InterruptedException
    {   
        Image img = new Image("/image/scissors.png");
        imgHuman.setImage(img);          

        String yourHand = "S";

        index = (int)(Math.random() * 10) % 3; 
        
        if(index == 0)
        {
            computerHand[index] = "R";
            Image computer = new Image("/image/rock.png");
            imgComputer.setImage(computer);
        }
        else if(index == 1)
        {    
            computerHand[index] = "P";
            Image computer = new Image("/image/paper.png");
            imgComputer.setImage(computer);
        }    
        else if(index == 2)        
        {
            computerHand[index] = "S";
            Image computer = new Image("/image/scissors.png");
            imgComputer.setImage(computer);
        }
                         
        if(yourHand.equals(computerHand[index]))
        {    
            numTies++;
            theWinner = "TIE"; 
            Image tieImage = new Image("/image/tie-face.png");
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(tieImage);  
            lblResult.setText("OH BUMMER!!! IT'S A TIE...");
        }
        
        else if(computerHand[index].equals("R"))
        {    
            numComputerWin++;
            theWinner = "COMPUTER";  
            Image loserImage = new Image("/image/loser-face.png");
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(loserImage);  
            lblResult.setText("YOU ARE A LA-HOOSER!!!");
        }    
            
        else if(computerHand[index].equals("P"))
        {    
            numYouWin++;
            theWinner = "YOU";  
            Image winnerImage = new Image("/image/winner-face.png");
                
            String yourResult = Integer.toString(numYouWin);
            lblYourScore.setText(yourResult);
            String cpuResult = Integer.toString(numComputerWin);
            lblCpuScore.setText(cpuResult);
            String tieResult = Integer.toString(numTies);
            lblTies.setText(tieResult);
                
            imgTitle.setImage(winnerImage);  
            lblResult.setText("YOU ARE THE WINNER!!!");
        }      
        
        switch (numOfFiveGames) {
            case 5:
                Image finalWinnerImage = new Image("/image/winner-face.png");
                Image finalLoserImage = new Image("/image/loser-face.png");
                Image finalTieImage = new Image("/image/tie-face.png");

                imgHuman.setVisible(false);
                imgComputer.setVisible(false);
                
                if (numYouWin == numComputerWin)  
                {
                    imgTitle.setImage(finalTieImage); 
                    lblResult.setText("THE GAME IS A DRAW!!!");
                }
                else if (numYouWin > numComputerWin)  
                {
                    imgTitle.setImage(finalWinnerImage);  
                    lblResult.setText("YOU WON THE GAME!!!");
                    playWinMusic("C:\\Users\\kidka\\Documents\\NetBeansProjects\\Final Project\\src\\audio\\flawless-victory.wav");
                }
                else if (numYouWin < numComputerWin)  
                {
                    imgTitle.setImage(finalLoserImage);  
                    lblResult.setText("YOU LOST THE GAME!!!");
                    playWinMusic("C:\\Users\\kidka\\Documents\\NetBeansProjects\\Final Project\\src\\audio\\you-lose.wav");
                }                
                                    
                btnRock.setVisible(false);
                btnPaper.setVisible(false);
                btnScissors.setVisible(false);
                
                numOfFiveGames = 1;
                numTies = 0;
                numYouWin = 0;
                numComputerWin = 0;                 

                break;                
            default:
                lblMatchCount.setText("GAME  " + numOfFiveGames + " / 5");
                numOfFiveGames = numOfFiveGames + 1;
                break;                
        }
    }
    
    public static void playWinMusic(String filepath)
    {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }    
    }    
    
    public void quitClick()
    {
        System.exit(0);
    }
 }    



   
        
        

 

