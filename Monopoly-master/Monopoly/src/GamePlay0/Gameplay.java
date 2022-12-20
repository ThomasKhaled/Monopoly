package GamePlay0;

import Playerpkg.PlayerCurrentPostion;
import NewGame.StartScreen;
import Playerpkg.JailOption;
import Playerpkg.Player;
import Playerpkg.DesitionPanel;
import Buildings.*;
import SaveAndLoadGame.SaveGame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Gameplay extends javax.swing.JFrame {

    private Thread s;
    private PlayerCurrentPostion pos;
    static int playerTurn = -1;
    private int turn = 0;
    private static int Res; //****************
    private Map<Integer, Zone> zoneMap;
    private int NumbOfPlayers;
    private Player[] player;
    private static ArrayList<JButton> Player_Car;
    private Map<Integer, Object> build;
    private boolean WinnerWinner;
    private Map<Integer, Player_pnl> playerPanelAccessMap;
    private DrawGamePlay draw;
    private zoneEvents events;
    private boolean DetectDice;

    public boolean isDetectDice() {
        return DetectDice;
    }

    public void setDetectDice(boolean DetectDice) {
        this.DetectDice = DetectDice;
    }
    
    private static Gameplay singleToneGameplay;
    
    
    public Gameplay() throws IOException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        WinnerWinner = false;
        draw = new DrawGamePlay();
        
    }


    public void setNumbOfPlayers(int NumbOfPlayers) {
        this.NumbOfPlayers = NumbOfPlayers;

    }

    public void setPlayer(Player[] player) throws IOException {
        this.player = player;

        pos = new PlayerCurrentPostion();
        zoneMapInitialization();
        playerPanelAccsessMapInitialization();
        SetPlayerPanels();
        //DrawGamePlay(false, null);
        draw.DrawGamePlay(false, null);

        //DisplayCiyInfo();
        // zoneEvents events = new zoneEvents();
        events = new zoneEvents();
        events.DisplayCiyInfo();

        IntializePlayers(NumbOfPlayers, player);
        DrawPlayers_pnl(NumbOfPlayers);

        IntializeBuildings();

    }

    public void SetPlayerPanels() {

        dice1.setImage("src/GamePlay/img/1.PNG", false);
        dice2.setImage("src/Gameplay/img/1.PNG", false);
        player_pnl1.setVisible(false);
        player_pnl2.setVisible(false);
        player_pnl3.setVisible(false);
        player_pnl4.setVisible(false);
        player_pnl5.setVisible(false);
        player_pnl6.setVisible(false);

        winner_lbl0.setVisible(false);
        winnerpic_lbl0.setVisible(false);
        winner_lbl1.setVisible(false);
        winnerpic_lbl1.setVisible(false);
        winner_lbl2.setVisible(false);
        winnerpic_lbl2.setVisible(false);
        winner_lbl3.setVisible(false);
        winnerpic_lbl3.setVisible(false);
        winner_lbl4.setVisible(false);
        winnerpic_lbl4.setVisible(false);
        winner_lbl5.setVisible(false);
        winnerpic_lbl5.setVisible(false);

        PlayAgainBtn.setVisible(false);
        Exit.setVisible(true);
        trade_pnl1.setVisible(false);
        Deal_btn.setVisible(false);
        NoDeal_btn.setVisible(false);
    }

    public Player[] getPlayer() {
        return player;
    }

    public void zoneMapInitialization() {
        zoneMap = new HashMap<Integer, Zone>();
        zoneMap.put(0, go);
        zoneMap.put(1, Mediter_Ranean);
        zoneMap.put(2, Community_Chest);
        zoneMap.put(3, Baltic);
        zoneMap.put(4, IncomeTax);
        zoneMap.put(5, RealRoad);
        zoneMap.put(6, Oriental);
        zoneMap.put(7, ChanceRed);
        zoneMap.put(8, Vermont);
        zoneMap.put(9, Connecticut);
        zoneMap.put(10, jail);
        zoneMap.put(11, States);
        zoneMap.put(12, Virginnia);
        zoneMap.put(13, pennsyl);
        zoneMap.put(14, stJames);
        zoneMap.put(15, CCT);
        zoneMap.put(16, Tenss);
        zoneMap.put(17, NewYork);
        zoneMap.put(18, parking);
        zoneMap.put(19, Kentucky);
        zoneMap.put(20, ChanceBlue);
        zoneMap.put(21, Indiana);
        zoneMap.put(22, Illinois);
        zoneMap.put(23, RailRoad);
        zoneMap.put(24, Atlantic);
        zoneMap.put(25, ventnor);
        zoneMap.put(26, waterWorks);
        zoneMap.put(27, MarvinGardens);
        zoneMap.put(28, goToJail);
        zoneMap.put(29, pacific);
        zoneMap.put(30, NorthCaro);
        zoneMap.put(31, communtityChestRight);
        zoneMap.put(32, pennsy);
        zoneMap.put(33, shorLline);
        zoneMap.put(34, OrangeChance);
        zoneMap.put(35, ParkPlace);

    }

    public Map<Integer, Zone> getZoneMap() {
        return zoneMap;
    }

    public void IntializePlayers(int NumOfPlayers, Player[] player) {
        Player_Car = new ArrayList<>();
        for (int i = 0; i < NumOfPlayers; i++) {
            Player_Car.add(new JButton());
            Player_Car.get(i).setBackground(player[i].getM_color());
            int postion = (i) * 20;
            player[i].setM_carXY(postion);
            Player_Car.get(i).setBounds(go.getX(), go.getY() + (go.getWidth() - 20 - postion), 60, 20);
            jPanel1.add(Player_Car.get(i));

            player[i].setM_balance(200);
            player[i].setM_inJail(false);
            player[i].setM_passByGo(false);
        }

    }

    private void DisEnabelEveryThing() {
        BuyCity_btn.setEnabled(false);
        jButton3.setEnabled(false);
        Build_btn.setEnabled(false);
        Trade_btn.setEnabled(false);
    }

    public void IntializeBuildings() {
        build = new HashMap<Integer, Object>();
        
        build.put(1, B1);
        build.put(3, B3);
        // build.put(5,B5 );
        build.put(6, B6);
        build.put(8, B8);
        build.put(9, B9);
        build.put(11, B11);
        build.put(12, B12);
        //build.put(13,B13 );
        build.put(14, B14);
        build.put(16, B16);
        build.put(17, B17);
        build.put(19, B19);
        build.put(21, B21);
        build.put(22, B22);
        // build.put(23,B23 );
        build.put(24, B24);
        build.put(25, B25);
        build.put(27, B27);
        build.put(29, B29);
        build.put(30, B30);
        build.put(32, B32);
        //build.put(33,B33 );
        build.put(35, B35);

        /*
         VBuidings vb =  (VBuidings)build.get(32); 
         vb.getNumOfHouses();
         */
    }

    public void DrawPlayers_pnl(int NumOfPlayers) {
        if (NumOfPlayers == 2) {
            player_pnl1.getBalance_lbl().setText(String.valueOf(player[0].getM_balance()));
            player_pnl1.getID_lbl().setText(String.valueOf(player[0].getM_id()));
            player_pnl1.getPlayercolor_pnl().setBackground(player[0].getM_color());
            player_pnl1.setVisible(true);

            player_pnl2.getBalance_lbl().setText(String.valueOf(player[1].getM_balance()));
            player_pnl2.getID_lbl().setText(String.valueOf(player[1].getM_id()));
            player_pnl2.getPlayercolor_pnl().setBackground(player[1].getM_color());
            player_pnl2.setVisible(true);
        } else if (NumOfPlayers == 3) {
            player_pnl1.getBalance_lbl().setText(String.valueOf(player[0].getM_balance()));
            player_pnl1.getID_lbl().setText(String.valueOf(player[0].getM_id()));
            player_pnl1.getPlayercolor_pnl().setBackground(player[0].getM_color());
            player_pnl1.setVisible(true);

            player_pnl2.getBalance_lbl().setText(String.valueOf(player[1].getM_balance()));
            player_pnl2.getID_lbl().setText(String.valueOf(player[1].getM_id()));
            player_pnl2.getPlayercolor_pnl().setBackground(player[1].getM_color());
            player_pnl2.setVisible(true);

            player_pnl3.getBalance_lbl().setText(String.valueOf(player[2].getM_balance()));
            player_pnl3.getID_lbl().setText(String.valueOf(player[2].getM_id()));
            player_pnl3.getPlayercolor_pnl().setBackground(player[2].getM_color());
            player_pnl3.setVisible(true);
        } else if (NumOfPlayers == 4) {
            player_pnl1.getBalance_lbl().setText(String.valueOf(player[0].getM_balance()));
            player_pnl1.getID_lbl().setText(String.valueOf(player[0].getM_id()));
            player_pnl1.getPlayercolor_pnl().setBackground(player[0].getM_color());
            player_pnl1.setVisible(true);

            player_pnl2.getBalance_lbl().setText(String.valueOf(player[1].getM_balance()));
            player_pnl2.getID_lbl().setText(String.valueOf(player[1].getM_id()));
            player_pnl2.getPlayercolor_pnl().setBackground(player[1].getM_color());
            player_pnl2.setVisible(true);

            player_pnl3.getBalance_lbl().setText(String.valueOf(player[2].getM_balance()));
            player_pnl3.getID_lbl().setText(String.valueOf(player[2].getM_id()));
            player_pnl3.getPlayercolor_pnl().setBackground(player[2].getM_color());
            player_pnl3.setVisible(true);

            player_pnl4.getBalance_lbl().setText(String.valueOf(player[3].getM_balance()));
            player_pnl4.getID_lbl().setText(String.valueOf(player[3].getM_id()));
            player_pnl4.getPlayercolor_pnl().setBackground(player[3].getM_color());
            player_pnl4.setVisible(true);
        } else if (NumOfPlayers == 5) {
            player_pnl1.getBalance_lbl().setText(String.valueOf(player[0].getM_balance()));
            player_pnl1.getID_lbl().setText(String.valueOf(player[0].getM_id()));
            player_pnl1.getPlayercolor_pnl().setBackground(player[0].getM_color());
            player_pnl1.setVisible(true);

            player_pnl2.setVisible(true);
            player_pnl2.getBalance_lbl().setText(String.valueOf(player[1].getM_balance()));
            player_pnl2.getID_lbl().setText(String.valueOf(player[1].getM_id()));
            player_pnl2.getPlayercolor_pnl().setBackground(player[1].getM_color());

            player_pnl3.getBalance_lbl().setText(String.valueOf(player[2].getM_balance()));
            player_pnl3.getID_lbl().setText(String.valueOf(player[2].getM_id()));
            player_pnl3.getPlayercolor_pnl().setBackground(player[2].getM_color());
            player_pnl3.setVisible(true);

            player_pnl4.getBalance_lbl().setText(String.valueOf(player[3].getM_balance()));
            player_pnl4.getID_lbl().setText(String.valueOf(player[3].getM_id()));
            player_pnl4.getPlayercolor_pnl().setBackground(player[3].getM_color());
            player_pnl4.setVisible(true);

            player_pnl5.getBalance_lbl().setText(String.valueOf(player[4].getM_balance()));
            player_pnl5.getID_lbl().setText(String.valueOf(player[4].getM_id()));
            player_pnl5.getPlayercolor_pnl().setBackground(player[4].getM_color());
            player_pnl5.setVisible(true);
        } else if (NumOfPlayers == 6) {
            player_pnl1.getBalance_lbl().setText(String.valueOf(player[0].getM_balance()));
            player_pnl1.getID_lbl().setText(String.valueOf(player[0].getM_id()));
            player_pnl1.getPlayercolor_pnl().setBackground(player[0].getM_color());
            player_pnl1.setVisible(true);

            player_pnl2.getBalance_lbl().setText(String.valueOf(player[1].getM_balance()));
            player_pnl2.getID_lbl().setText(String.valueOf(player[1].getM_id()));
            player_pnl2.getPlayercolor_pnl().setBackground(player[1].getM_color());
            player_pnl2.setVisible(true);

            player_pnl3.getBalance_lbl().setText(String.valueOf(player[2].getM_balance()));
            player_pnl3.getID_lbl().setText(String.valueOf(player[2].getM_id()));
            player_pnl3.getPlayercolor_pnl().setBackground(player[2].getM_color());
            player_pnl3.setVisible(true);

            player_pnl4.getBalance_lbl().setText(String.valueOf(player[3].getM_balance()));
            player_pnl4.getID_lbl().setText(String.valueOf(player[3].getM_id()));
            player_pnl4.getPlayercolor_pnl().setBackground(player[3].getM_color());
            player_pnl4.setVisible(true);

            player_pnl5.getBalance_lbl().setText(String.valueOf(player[4].getM_balance()));
            player_pnl5.getID_lbl().setText(String.valueOf(player[4].getM_id()));
            player_pnl5.getPlayercolor_pnl().setBackground(player[4].getM_color());
            player_pnl5.setVisible(true);

            player_pnl6.getBalance_lbl().setText(String.valueOf(player[5].getM_balance()));
            player_pnl6.getID_lbl().setText(String.valueOf(player[5].getM_id()));
            player_pnl6.getPlayercolor_pnl().setBackground(player[5].getM_color());
            player_pnl6.setVisible(true);
        }
    }

    private void PassByGo() {
        player[playerTurn].setM_balance(player[playerTurn].getM_balance() + 200);
        updatePlayersBalance();
    }

    private void GoToJail() {
        //int currentPos = pos.getCurrentPos(playerTurn);
        pos.SetPlayer(playerTurn, 18);
        player[playerTurn].setInJail(2);
        Movement(18, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
        s.start();
    }

    public void Movement(int NumOfSteps, int x, int y, int pl) {
        
        int width = 65;
        int height = 20;
        s = new Thread(new Runnable() {

            public void run() {

                int cnt = 0;

                while (true) {

                    try {
                        SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_token_thimble_move.wav");
                    } catch (IOException ex) {
                        Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    int currentX = Player_Car.get(pl).getX();
                    int currentY = Player_Car.get(pl).getY();

                    //UP
                    if (currentX + (parking.getHeight() - currentX) > x && currentX < jPanel1.getWidth() && currentY == y) {
                        for (int i = Player_Car.get(pl).getX(); i < currentX + 70; i++) {
                            if (Player_Car.get(pl).getX() + 10 >= goToJail.getX()) {
                                Player_Car.get(pl).setBounds(goToJail.getX() + (goToJail.getWidth() - height - x), goToJail.getY() + goToJail.getWidth() - width, height, width);
                                //cnt--;
                                break;

                            } else {
                                Player_Car.get(pl).setBounds(i, y, width, height);
                            }

                            try {
                                Thread.sleep(1);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }

                    //LEFT
                    if (currentY >= y && currentY <= jPanel1.getHeight() && currentX == x) {
                        for (int i = Player_Car.get(pl).getY(); i > currentY - 70; i--) {
                            if (Player_Car.get(pl).getY() <= (parking.getWidth())) {
                                Player_Car.get(pl).setBounds(parking.getX() + (parking.getWidth() - width), y, width, height);
                                //cnt--;
                                break;
                            } else {
                                Player_Car.get(pl).setBounds(Player_Car.get(pl).getX(), i, height, width);
                            }

                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    //RIGHT
                    if (currentY + (goToJail.getWidth() - currentY) >= y && currentY <= go.getY() + go.getHeight() && currentX == go.getX() + (go.getWidth() - height - x)) {

                        for (int i = currentY; i < currentY + 70; i++) {
                            if (Player_Car.get(pl).getY() > go.getY() - 5) {
                                Player_Car.get(pl).setBounds(go.getX(), go.getY() + (go.getWidth() - height - y), width, height);
                                //cnt--;
                                break;
                            }
                            Player_Car.get(pl).setBounds(currentX, i, height, width);

                            try {
                                Thread.sleep(1);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                    //Down
                    // System.out.println(currentX + " " + (go.getX()+go.getWidth()) + " " + currentY + " " + (go.getY()+(go.getHeight()-height-y)));
                    if (currentX >= 0 && currentX <= (go.getX() + go.getWidth()) && currentY == (go.getY() + (go.getHeight() - height - y))) {
                        for (int i = currentX; i > currentX - 70; i--) {
                            if (Player_Car.get(pl).getX() <= x) {
                                Player_Car.get(pl).setBounds(x, jail.getY(), height, width);
                                cnt--;
                                break;
                            } else {
                                Player_Car.get(pl).setBounds(i, currentY, width, height);
                            }

                            try {
                                Thread.sleep(1);

                            } catch (InterruptedException ex) {
                                Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }

                    cnt++;

                    //if pass by go
                    //(pos.getCurrentPos(pl)-cnt)%36==0
                    if ((pos.getCurrentPos(pl) - cnt) % 36 == 0 && (turn - 1) != playerTurn && player[playerTurn].getInJail() == 0) {
                        PassByGo();
                    }

                    if (cnt == NumOfSteps) {
                        try {
                            SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_token_thimble_move.wav");
                        } catch (IOException ex) {
                            Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (pos.getCurrentPos(pl) == 2 || pos.getCurrentPos(pl) == 15 || pos.getCurrentPos(pl) == 31) {
                            DrawingCards("Community Chest");
                        } else if (pos.getCurrentPos(pl) == 7 || pos.getCurrentPos(pl) == 20 || pos.getCurrentPos(pl) == 34) {
                            DrawingCards("Chance");
                        } else if (pos.getCurrentPos(pl) == 10) {
                            player[playerTurn].setInJail(2);
                        } else if (pos.getCurrentPos(pl) == 28) {
                            GoToJail();
                        }
                        //checkIfZoneIsOwned(pos.getCurrentPos(player[playerTurn].getM_id()) , playerTurn);
                        someConditions();

                        //System.out.println(pl + " -- " + pos.getCurrentPos(pl));
                        jButton3.setEnabled(true);
                        cnt = 0;
                        break;
                    }
                    jPanel1.repaint();
                }

                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    private void DrawingCards(String cardType) {
        if (cardType == "Community Chest") {
            try {
                SoundEffects.PlaySound("src/Gameplay/soundEffects/104207086-game-treasure-06.wav");
            } catch (IOException ex) {
                Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (card.displayCommunityChestCards() >= -1) {
                int currentPos = pos.getCurrentPos(playerTurn);
                int randomNumber = card.ApplyCardEffect("CommunityChest", player[playerTurn], playerTurn, pos, NumbOfPlayers, player);
                if (randomNumber == 1) {
                    pos.SetPlayer(playerTurn, (36 - currentPos) % 36);
                    Movement((36 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                } else if (randomNumber == 7) {
                    pos.SetPlayer(playerTurn, (46 - currentPos) % 36);
                    Movement((46 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    //player[playerTurn].setM_inJail(true);
                    player[playerTurn].setInJail(2);
                    s.start();
                }
                updatePlayersBalance();
            }
        } else if (cardType == "Chance") {
            if (card.displayChanceCards() >= -1) {
                int currentPos = pos.getCurrentPos(playerTurn);
                int randomNumber = card.ApplyCardEffect("Chance", player[playerTurn], playerTurn, pos, NumbOfPlayers, player);
                if (randomNumber == 1) {
                    pos.SetPlayer(playerTurn, (36 - currentPos) % 36);
                    Movement((36 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                } else if (randomNumber == 2) {
                    pos.SetPlayer(playerTurn, (58 - currentPos) % 36);
                    Movement((58 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                } else if (randomNumber == 4 && currentPos == 7) {
                    pos.SetPlayer(playerTurn, (49 - currentPos) % 36);
                    Movement((49 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                    checkIfZoneIsOwned(pos.getCurrentPos(player[playerTurn].getM_id()), playerTurn);

                } else if (randomNumber == 4 && currentPos == 20) {
                    pos.SetPlayer(playerTurn, (59 - currentPos) % 36);
                    Movement((59 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                    checkIfZoneIsOwned(pos.getCurrentPos(player[playerTurn].getM_id()), playerTurn);
                } else if (randomNumber == 4 && currentPos == 34) {
                    pos.SetPlayer(playerTurn, (41 - currentPos) % 36);
                    Movement((41 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                    checkIfZoneIsOwned(pos.getCurrentPos(player[playerTurn].getM_id()), playerTurn);
                } else if (randomNumber == 9) {
                    pos.SetPlayer(playerTurn, (46 - currentPos) % 36);
                    Movement((46 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    //player[playerTurn].setM_inJail(true);
                    player[playerTurn].setInJail(2);
                    s.start();
                } else if (randomNumber == 12 && currentPos == 7) {
                    pos.SetPlayer(playerTurn, (59 - currentPos) % 36);
                    Movement((59 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                } else if (randomNumber == 12 && currentPos == 20) {
                    pos.SetPlayer(playerTurn, (41 - currentPos) % 36);
                    Movement((41 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                } else if (randomNumber == 12 && currentPos == 34) {
                    pos.SetPlayer(playerTurn, (59 - currentPos) % 36);
                    Movement((59 - currentPos) % 36, player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                    s.start();
                }
                updatePlayersBalance();
            }
        }
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void updatePlayersBalance() {
        player_pnl1.getBalance_lbl().setText(String.valueOf(player[0].getM_balance()));
        player_pnl1.setBalance_lbl(player_pnl1.getBalance_lbl());
        player_pnl2.getBalance_lbl().setText(String.valueOf(player[1].getM_balance()));
        player_pnl2.setBalance_lbl(player_pnl2.getBalance_lbl());
        player_pnl3.getBalance_lbl().setText(String.valueOf(player[2].getM_balance()));
        player_pnl3.setBalance_lbl(player_pnl3.getBalance_lbl());
        player_pnl4.getBalance_lbl().setText(String.valueOf(player[3].getM_balance()));
        player_pnl4.setBalance_lbl(player_pnl4.getBalance_lbl());
        player_pnl5.getBalance_lbl().setText(String.valueOf(player[4].getM_balance()));
        player_pnl5.setBalance_lbl(player_pnl5.getBalance_lbl());
        player_pnl6.getBalance_lbl().setText(String.valueOf(player[5].getM_balance()));
        player_pnl6.setBalance_lbl(player_pnl6.getBalance_lbl());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Save = new javax.swing.JButton();
        PlayAgainBtn = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        gameOver1 = new NewGame.GameOver();
        jPanel1 = new javax.swing.JPanel();
        go = new GamePlay0.Zone(0);
        jail = new GamePlay0.Zone(10);
        parking = new GamePlay0.Zone(18);
        goToJail = new GamePlay0.Zone(28);
        MarvinGardens = new GamePlay0.Zone(24,48,120,360,850,1025,1200,150,150,280,"Yellow",27);
        B27 = new Buildings.HBuildings();
        ventnor = new GamePlay0.Zone(22,44,110,330,800,975,1150,150,150,260,"Yellow",25);
        B25 = new Buildings.HBuildings();
        Atlantic = new GamePlay0.Zone(22,44,110,330,800,975,1150,150,150,260,"Yellow",24);
        B24 = new Buildings.HBuildings();
        waterWorks = new GamePlay0.Zone(4,150,26);
        RailRoad = new GamePlay0.Zone(25,50,100,200,200,23);
        Illinois = new GamePlay0.Zone(20,40,100,300,750,925,1100,150,150,240,"Red",22);
        B22 = new Buildings.HBuildings();
        Indiana = new GamePlay0.Zone(18,36,90,250,700,875,1050,150,150,220,"Red",21);
        B21 = new Buildings.HBuildings();
        ChanceBlue = new GamePlay0.Zone(20);
        Kentucky = new GamePlay0.Zone(18,36,90,250,700,875,1050,150,150,220,"Red",19);
        B19 = new Buildings.HBuildings();
        Mediter_Ranean = new GamePlay0.Zone(2,4,10,30,90,160,250,50,50,60,"Brown",1);
        B1 = new Buildings.HBuildings();
        Community_Chest = new GamePlay0.Zone(2);
        Baltic = new GamePlay0.Zone(4,8,20,60,180,320,450,50,50,60,"Brown",3);
        B3 = new Buildings.HBuildings();
        IncomeTax = new GamePlay0.Zone(4);
        RealRoad = new GamePlay0.Zone(25,50,100,200,200,5);
        Oriental = new GamePlay0.Zone(6,12,30,90,270,400,550,50,50,100,"Light Blue",6);
        B6 = new Buildings.HBuildings();
        ChanceRed = new GamePlay0.Zone(7);
        Vermont = new GamePlay0.Zone(6,12,30,90,270,400,550,50,50,100,"Light Blue",8);
        B8 = new Buildings.HBuildings();
        Connecticut = new GamePlay0.Zone(8,16,40,100,300,450,600,50,50,100,"Light Blue",9);
        B9 = new Buildings.HBuildings();
        pacific = new GamePlay0.Zone(26,52,130,390,900,1100,1275,200,200,300,"Green",29);
        B29 = new Buildings.VBuidings();
        NorthCaro = new GamePlay0.Zone(26,52,130,390,900,1100,1275,200,200,300,"Green",30);
        B30 = new Buildings.VBuidings();
        communtityChestRight = new GamePlay0.Zone(31);
        pennsy = new GamePlay0.Zone(28,56,150,450,1000,1200,1400,200,200,320,"Green",32);
        B32 = new Buildings.VBuidings();
        shorLline = new GamePlay0.Zone(25,50,100,200,200,33);
        OrangeChance = new GamePlay0.Zone(34);
        ParkPlace = new GamePlay0.Zone(35,44,175,500,1100,1300,1500,200,200,350,"Dark Blue",35);
        B35 = new Buildings.VBuidings();
        NewYork = new GamePlay0.Zone(16,32,80,220,600,800,1000,50,50,200,"Orange",17);
        B17 = new Buildings.VBuidings();
        CCT = new GamePlay0.Zone(15);
        stJames = new GamePlay0.Zone(14,28,70,200,550,750,950,50,50,180,"Orange",14);
        B14 = new Buildings.VBuidings();
        pennsyl = new GamePlay0.Zone(25,50,100,200,200,13);
        Virginnia = new GamePlay0.Zone(12,24,60,180,500,700,900,100,100,160,"Pink",12);
        B12 = new Buildings.VBuidings();
        States = new GamePlay0.Zone(10,20,50,150,450,625,750,100,100,140,"Pink",11);
        B11 = new Buildings.VBuidings();
        Tenss = new GamePlay0.Zone(14,28,70,200,550,750,950,50,50,180,"Orange",16);
        B16 = new Buildings.VBuidings();
        MONOMAN = new GamePlay0.Zone();
        orange = new GamePlay0.Zone();
        bluetreasure = new GamePlay0.Zone();
        jPanel2 = new javax.swing.JPanel();
        BuyCity_btn = new javax.swing.JButton();
        Trade_btn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        dice2 = new GamePlay0.Dice();
        dice1 = new GamePlay0.Dice();
        winner_lbl1 = new javax.swing.JLabel();
        winnerpic_lbl1 = new javax.swing.JLabel();
        winner_lbl2 = new javax.swing.JLabel();
        winnerpic_lbl2 = new javax.swing.JLabel();
        winner_lbl3 = new javax.swing.JLabel();
        winnerpic_lbl3 = new javax.swing.JLabel();
        winner_lbl4 = new javax.swing.JLabel();
        winnerpic_lbl4 = new javax.swing.JLabel();
        winner_lbl5 = new javax.swing.JLabel();
        winnerpic_lbl5 = new javax.swing.JLabel();
        winner_lbl0 = new javax.swing.JLabel();
        winnerpic_lbl0 = new javax.swing.JLabel();
        player_pnl1 = new GamePlay0.Player_pnl();
        player_pnl2 = new GamePlay0.Player_pnl();
        player_pnl3 = new GamePlay0.Player_pnl();
        player_pnl4 = new GamePlay0.Player_pnl();
        player_pnl5 = new GamePlay0.Player_pnl();
        player_pnl6 = new GamePlay0.Player_pnl();
        Build_btn = new javax.swing.JButton();
        Deal_btn = new javax.swing.JButton();
        NoDeal_btn = new javax.swing.JButton();
        trade_pnl1 = new GamePlay0.trade_pnl();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        Save.setBackground(new java.awt.Color(153, 0, 0));
        Save.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Save.setForeground(new java.awt.Color(255, 153, 0));
        Save.setText("Save Game");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        getContentPane().add(Save);
        Save.setBounds(980, 0, 190, 37);

        PlayAgainBtn.setBackground(new java.awt.Color(153, 0, 0));
        PlayAgainBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        PlayAgainBtn.setForeground(new java.awt.Color(255, 153, 0));
        PlayAgainBtn.setText("Play Again");
        PlayAgainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayAgainBtnActionPerformed(evt);
            }
        });
        getContentPane().add(PlayAgainBtn);
        PlayAgainBtn.setBounds(780, 0, 190, 37);

        Exit.setBackground(new java.awt.Color(153, 0, 0));
        Exit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 153, 0));
        Exit.setText("EXIT");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit);
        Exit.setBounds(580, 0, 190, 37);
        getContentPane().add(gameOver1);
        gameOver1.setBounds(0, -730, 1366, 768);

        jPanel1.setBackground(new java.awt.Color(204, 218, 242));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(null);

        go.setMaximumSize(new java.awt.Dimension(120, 120));
        go.setMinimumSize(new java.awt.Dimension(120, 120));
        go.setPreferredSize(new java.awt.Dimension(120, 120));

        javax.swing.GroupLayout goLayout = new javax.swing.GroupLayout(go);
        go.setLayout(goLayout);
        goLayout.setHorizontalGroup(
            goLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        goLayout.setVerticalGroup(
            goLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(go);
        go.setBounds(750, 608, 120, 120);

        javax.swing.GroupLayout jailLayout = new javax.swing.GroupLayout(jail);
        jail.setLayout(jailLayout);
        jailLayout.setHorizontalGroup(
            jailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jailLayout.setVerticalGroup(
            jailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jail);
        jail.setBounds(0, 608, 120, 120);

        javax.swing.GroupLayout parkingLayout = new javax.swing.GroupLayout(parking);
        parking.setLayout(parkingLayout);
        parkingLayout.setHorizontalGroup(
            parkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        parkingLayout.setVerticalGroup(
            parkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(parking);
        parking.setBounds(0, 0, 120, 120);

        javax.swing.GroupLayout goToJailLayout = new javax.swing.GroupLayout(goToJail);
        goToJail.setLayout(goToJailLayout);
        goToJailLayout.setHorizontalGroup(
            goToJailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        goToJailLayout.setVerticalGroup(
            goToJailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(goToJail);
        goToJail.setBounds(750, 0, 120, 120);

        MarvinGardens.setMaximumSize(new java.awt.Dimension(70, 120));
        MarvinGardens.setMinimumSize(new java.awt.Dimension(70, 120));
        MarvinGardens.setLayout(null);
        MarvinGardens.add(B27);
        B27.setBounds(10, 110, 51, 16);

        jPanel1.add(MarvinGardens);
        MarvinGardens.setBounds(680, 0, 70, 120);

        ventnor.setMaximumSize(new java.awt.Dimension(70, 120));
        ventnor.setMinimumSize(new java.awt.Dimension(70, 120));
        ventnor.setLayout(null);
        ventnor.add(B25);
        B25.setBounds(10, 110, 51, 16);

        jPanel1.add(ventnor);
        ventnor.setBounds(540, 0, 70, 120);

        Atlantic.setMaximumSize(new java.awt.Dimension(70, 120));
        Atlantic.setMinimumSize(new java.awt.Dimension(70, 120));
        Atlantic.setLayout(null);
        Atlantic.add(B24);
        B24.setBounds(10, 110, 51, 16);

        jPanel1.add(Atlantic);
        Atlantic.setBounds(470, 0, 70, 120);

        waterWorks.setMaximumSize(new java.awt.Dimension(70, 120));
        waterWorks.setMinimumSize(new java.awt.Dimension(70, 120));
        waterWorks.setLayout(null);
        jPanel1.add(waterWorks);
        waterWorks.setBounds(610, 0, 70, 120);

        RailRoad.setMaximumSize(new java.awt.Dimension(70, 120));
        RailRoad.setMinimumSize(new java.awt.Dimension(70, 120));
        RailRoad.setLayout(null);
        jPanel1.add(RailRoad);
        RailRoad.setBounds(400, 0, 70, 120);

        Illinois.setMaximumSize(new java.awt.Dimension(70, 120));
        Illinois.setMinimumSize(new java.awt.Dimension(70, 120));
        Illinois.setLayout(null);
        Illinois.add(B22);
        B22.setBounds(10, 110, 51, 16);

        jPanel1.add(Illinois);
        Illinois.setBounds(330, 0, 70, 120);

        Indiana.setMaximumSize(new java.awt.Dimension(70, 120));
        Indiana.setMinimumSize(new java.awt.Dimension(70, 120));
        Indiana.setLayout(null);
        Indiana.add(B21);
        B21.setBounds(10, 110, 51, 16);

        jPanel1.add(Indiana);
        Indiana.setBounds(260, 0, 70, 120);

        ChanceBlue.setMaximumSize(new java.awt.Dimension(70, 120));
        ChanceBlue.setMinimumSize(new java.awt.Dimension(70, 120));
        ChanceBlue.setLayout(null);
        jPanel1.add(ChanceBlue);
        ChanceBlue.setBounds(190, 0, 70, 120);

        Kentucky.setMaximumSize(new java.awt.Dimension(70, 120));
        Kentucky.setMinimumSize(new java.awt.Dimension(70, 120));
        Kentucky.setName(""); // NOI18N
        Kentucky.setPreferredSize(new java.awt.Dimension(70, 0));
        Kentucky.setVerifyInputWhenFocusTarget(false);
        Kentucky.setLayout(null);
        Kentucky.add(B19);
        B19.setBounds(10, 110, 51, 16);

        jPanel1.add(Kentucky);
        Kentucky.setBounds(120, 0, 70, 120);

        Mediter_Ranean.setMaximumSize(new java.awt.Dimension(70, 120));
        Mediter_Ranean.setMinimumSize(new java.awt.Dimension(70, 120));
        Mediter_Ranean.setLayout(null);
        Mediter_Ranean.add(B1);
        B1.setBounds(10, 0, 51, 16);

        jPanel1.add(Mediter_Ranean);
        Mediter_Ranean.setBounds(680, 608, 70, 120);

        Community_Chest.setMaximumSize(new java.awt.Dimension(70, 120));
        Community_Chest.setMinimumSize(new java.awt.Dimension(70, 120));

        javax.swing.GroupLayout Community_ChestLayout = new javax.swing.GroupLayout(Community_Chest);
        Community_Chest.setLayout(Community_ChestLayout);
        Community_ChestLayout.setHorizontalGroup(
            Community_ChestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        Community_ChestLayout.setVerticalGroup(
            Community_ChestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(Community_Chest);
        Community_Chest.setBounds(610, 608, 70, 120);

        Baltic.setMaximumSize(new java.awt.Dimension(70, 120));
        Baltic.setMinimumSize(new java.awt.Dimension(70, 120));
        Baltic.setLayout(null);
        Baltic.add(B3);
        B3.setBounds(10, 0, 51, 16);

        jPanel1.add(Baltic);
        Baltic.setBounds(540, 608, 70, 120);

        IncomeTax.setMaximumSize(new java.awt.Dimension(70, 120));
        IncomeTax.setMinimumSize(new java.awt.Dimension(70, 120));
        IncomeTax.setLayout(null);
        jPanel1.add(IncomeTax);
        IncomeTax.setBounds(470, 608, 70, 120);

        RealRoad.setMaximumSize(new java.awt.Dimension(70, 120));
        RealRoad.setMinimumSize(new java.awt.Dimension(70, 120));
        RealRoad.setLayout(null);
        jPanel1.add(RealRoad);
        RealRoad.setBounds(400, 608, 70, 120);

        Oriental.setMaximumSize(new java.awt.Dimension(70, 120));
        Oriental.setMinimumSize(new java.awt.Dimension(70, 120));
        Oriental.setLayout(null);
        Oriental.add(B6);
        B6.setBounds(10, 0, 51, 16);

        jPanel1.add(Oriental);
        Oriental.setBounds(330, 608, 70, 120);

        ChanceRed.setMaximumSize(new java.awt.Dimension(70, 120));
        ChanceRed.setMinimumSize(new java.awt.Dimension(70, 120));
        ChanceRed.setLayout(null);
        jPanel1.add(ChanceRed);
        ChanceRed.setBounds(260, 608, 70, 120);

        Vermont.setMaximumSize(new java.awt.Dimension(70, 120));
        Vermont.setMinimumSize(new java.awt.Dimension(70, 120));
        Vermont.setLayout(null);
        Vermont.add(B8);
        B8.setBounds(10, 0, 51, 16);

        jPanel1.add(Vermont);
        Vermont.setBounds(190, 608, 70, 120);

        Connecticut.setMaximumSize(new java.awt.Dimension(70, 120));
        Connecticut.setMinimumSize(new java.awt.Dimension(70, 120));
        Connecticut.setPreferredSize(new java.awt.Dimension(70, 120));
        Connecticut.setLayout(null);
        Connecticut.add(B9);
        B9.setBounds(10, 0, 51, 16);

        jPanel1.add(Connecticut);
        Connecticut.setBounds(120, 608, 70, 120);

        pacific.setPreferredSize(new java.awt.Dimension(120, 70));
        pacific.setLayout(null);
        pacific.add(B29);
        B29.setBounds(0, 10, 16, 54);

        jPanel1.add(pacific);
        pacific.setBounds(750, 120, 120, 70);

        NorthCaro.setMaximumSize(new java.awt.Dimension(120, 70));
        NorthCaro.setMinimumSize(new java.awt.Dimension(120, 70));
        NorthCaro.setPreferredSize(new java.awt.Dimension(120, 70));
        NorthCaro.setLayout(null);
        NorthCaro.add(B30);
        B30.setBounds(0, 10, 16, 54);

        jPanel1.add(NorthCaro);
        NorthCaro.setBounds(750, 190, 120, 70);

        communtityChestRight.setMaximumSize(new java.awt.Dimension(120, 70));
        communtityChestRight.setMinimumSize(new java.awt.Dimension(120, 70));
        communtityChestRight.setPreferredSize(new java.awt.Dimension(120, 70));
        communtityChestRight.setLayout(null);
        jPanel1.add(communtityChestRight);
        communtityChestRight.setBounds(750, 260, 120, 70);

        pennsy.setMaximumSize(new java.awt.Dimension(120, 70));
        pennsy.setMinimumSize(new java.awt.Dimension(120, 70));
        pennsy.setName(""); // NOI18N
        pennsy.setPreferredSize(new java.awt.Dimension(120, 70));
        pennsy.setLayout(null);
        pennsy.add(B32);
        B32.setBounds(0, 10, 16, 54);

        jPanel1.add(pennsy);
        pennsy.setBounds(750, 330, 120, 70);

        shorLline.setMaximumSize(new java.awt.Dimension(120, 70));
        shorLline.setMinimumSize(new java.awt.Dimension(120, 70));
        shorLline.setPreferredSize(new java.awt.Dimension(120, 70));
        shorLline.setLayout(null);
        jPanel1.add(shorLline);
        shorLline.setBounds(750, 400, 120, 70);

        OrangeChance.setMaximumSize(new java.awt.Dimension(120, 70));
        OrangeChance.setMinimumSize(new java.awt.Dimension(120, 70));
        OrangeChance.setPreferredSize(new java.awt.Dimension(120, 70));
        OrangeChance.setLayout(null);
        jPanel1.add(OrangeChance);
        OrangeChance.setBounds(750, 470, 120, 70);

        ParkPlace.setMaximumSize(new java.awt.Dimension(120, 70));
        ParkPlace.setMinimumSize(new java.awt.Dimension(120, 70));
        ParkPlace.setPreferredSize(new java.awt.Dimension(120, 70));
        ParkPlace.setLayout(null);
        ParkPlace.add(B35);
        B35.setBounds(0, 10, 16, 54);

        jPanel1.add(ParkPlace);
        ParkPlace.setBounds(750, 540, 120, 70);

        NewYork.setLayout(null);
        NewYork.add(B17);
        B17.setBounds(110, 10, 16, 54);

        jPanel1.add(NewYork);
        NewYork.setBounds(0, 118, 120, 70);

        CCT.setLayout(null);
        jPanel1.add(CCT);
        CCT.setBounds(0, 258, 120, 70);

        stJames.setMaximumSize(new java.awt.Dimension(120, 70));
        stJames.setMinimumSize(new java.awt.Dimension(120, 70));
        stJames.setPreferredSize(new java.awt.Dimension(120, 70));
        stJames.setLayout(null);
        stJames.add(B14);
        B14.setBounds(110, 10, 16, 54);

        jPanel1.add(stJames);
        stJames.setBounds(0, 328, 120, 70);

        pennsyl.setMaximumSize(new java.awt.Dimension(120, 70));
        pennsyl.setMinimumSize(new java.awt.Dimension(120, 70));
        pennsyl.setPreferredSize(new java.awt.Dimension(120, 70));
        pennsyl.setLayout(null);
        jPanel1.add(pennsyl);
        pennsyl.setBounds(0, 398, 120, 70);

        Virginnia.setMaximumSize(new java.awt.Dimension(120, 70));
        Virginnia.setMinimumSize(new java.awt.Dimension(120, 70));
        Virginnia.setPreferredSize(new java.awt.Dimension(120, 70));
        Virginnia.setLayout(null);
        Virginnia.add(B12);
        B12.setBounds(110, 10, 16, 54);

        jPanel1.add(Virginnia);
        Virginnia.setBounds(0, 468, 120, 70);

        States.setMaximumSize(new java.awt.Dimension(120, 70));
        States.setMinimumSize(new java.awt.Dimension(120, 70));
        States.setLayout(null);
        States.add(B11);
        B11.setBounds(110, 10, 16, 54);

        jPanel1.add(States);
        States.setBounds(0, 538, 120, 70);

        Tenss.setLayout(null);
        Tenss.add(B16);
        B16.setBounds(110, 10, 16, 54);

        jPanel1.add(Tenss);
        Tenss.setBounds(0, 188, 120, 70);

        javax.swing.GroupLayout MONOMANLayout = new javax.swing.GroupLayout(MONOMAN);
        MONOMAN.setLayout(MONOMANLayout);
        MONOMANLayout.setHorizontalGroup(
            MONOMANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );
        MONOMANLayout.setVerticalGroup(
            MONOMANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        jPanel1.add(MONOMAN);
        MONOMAN.setBounds(281, 248, 281, 228);

        javax.swing.GroupLayout orangeLayout = new javax.swing.GroupLayout(orange);
        orange.setLayout(orangeLayout);
        orangeLayout.setHorizontalGroup(
            orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        orangeLayout.setVerticalGroup(
            orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );

        jPanel1.add(orange);
        orange.setBounds(600, 443, 137, 139);

        javax.swing.GroupLayout bluetreasureLayout = new javax.swing.GroupLayout(bluetreasure);
        bluetreasure.setLayout(bluetreasureLayout);
        bluetreasureLayout.setHorizontalGroup(
            bluetreasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        bluetreasureLayout.setVerticalGroup(
            bluetreasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        jPanel1.add(bluetreasure);
        bluetreasure.setBounds(138, 138, 133, 133);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 875, 728);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 102, 0), new java.awt.Color(255, 0, 51), new java.awt.Color(255, 102, 102), new java.awt.Color(204, 0, 102)));
        jPanel2.setLayout(null);

        BuyCity_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BuyCity_btn.setText("BuyCity");
        BuyCity_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyCity_btnActionPerformed(evt);
            }
        });
        jPanel2.add(BuyCity_btn);
        BuyCity_btn.setBounds(20, 420, 90, 23);

        Trade_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Trade_btn.setText("Trade");
        Trade_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Trade_btnActionPerformed(evt);
            }
        });
        jPanel2.add(Trade_btn);
        Trade_btn.setBounds(260, 420, 90, 23);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("IS Rolled ?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(20, 650, 100, 50);

        javax.swing.GroupLayout dice2Layout = new javax.swing.GroupLayout(dice2);
        dice2.setLayout(dice2Layout);
        dice2Layout.setHorizontalGroup(
            dice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        dice2Layout.setVerticalGroup(
            dice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel2.add(dice2);
        dice2.setBounds(220, 640, 70, 60);

        javax.swing.GroupLayout dice1Layout = new javax.swing.GroupLayout(dice1);
        dice1.setLayout(dice1Layout);
        dice1Layout.setHorizontalGroup(
            dice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        dice1Layout.setVerticalGroup(
            dice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel2.add(dice1);
        dice1.setBounds(140, 640, 70, 60);

        winner_lbl1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        winner_lbl1.setText("Winner");
        jPanel2.add(winner_lbl1);
        winner_lbl1.setBounds(200, 0, 50, 33);

        winnerpic_lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/player_win.png"))); // NOI18N
        jPanel2.add(winnerpic_lbl1);
        winnerpic_lbl1.setBounds(160, 0, 120, 50);

        winner_lbl2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        winner_lbl2.setText("Winner");
        jPanel2.add(winner_lbl2);
        winner_lbl2.setBounds(360, 0, 50, 33);

        winnerpic_lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/player_win.png"))); // NOI18N
        jPanel2.add(winnerpic_lbl2);
        winnerpic_lbl2.setBounds(320, 0, 120, 50);

        winner_lbl3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        winner_lbl3.setText("Winner");
        jPanel2.add(winner_lbl3);
        winner_lbl3.setBounds(50, 220, 50, 33);

        winnerpic_lbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/player_win.png"))); // NOI18N
        jPanel2.add(winnerpic_lbl3);
        winnerpic_lbl3.setBounds(10, 220, 120, 50);

        winner_lbl4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        winner_lbl4.setText("Winner");
        jPanel2.add(winner_lbl4);
        winner_lbl4.setBounds(200, 220, 50, 33);

        winnerpic_lbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/player_win.png"))); // NOI18N
        jPanel2.add(winnerpic_lbl4);
        winnerpic_lbl4.setBounds(160, 220, 120, 50);

        winner_lbl5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        winner_lbl5.setText("Winner");
        jPanel2.add(winner_lbl5);
        winner_lbl5.setBounds(360, 220, 50, 33);

        winnerpic_lbl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/player_win.png"))); // NOI18N
        jPanel2.add(winnerpic_lbl5);
        winnerpic_lbl5.setBounds(320, 220, 120, 50);

        winner_lbl0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        winner_lbl0.setText("Winner");
        jPanel2.add(winner_lbl0);
        winner_lbl0.setBounds(50, 0, 50, 33);

        winnerpic_lbl0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/player_win.png"))); // NOI18N
        jPanel2.add(winnerpic_lbl0);
        winnerpic_lbl0.setBounds(10, 0, 120, 50);
        jPanel2.add(player_pnl1);
        player_pnl1.setBounds(10, 30, 120, 150);
        jPanel2.add(player_pnl2);
        player_pnl2.setBounds(160, 30, 120, 150);
        jPanel2.add(player_pnl3);
        player_pnl3.setBounds(320, 30, 120, 150);
        jPanel2.add(player_pnl4);
        player_pnl4.setBounds(10, 250, 120, 150);
        jPanel2.add(player_pnl5);
        player_pnl5.setBounds(160, 250, 120, 150);
        jPanel2.add(player_pnl6);
        player_pnl6.setBounds(320, 250, 120, 150);

        Build_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Build_btn.setText("Build");
        Build_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Build_btnActionPerformed(evt);
            }
        });
        jPanel2.add(Build_btn);
        Build_btn.setBounds(140, 420, 100, 23);

        Deal_btn.setText("Deal");
        Deal_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Deal_btnActionPerformed(evt);
            }
        });
        jPanel2.add(Deal_btn);
        Deal_btn.setBounds(370, 460, 80, 23);

        NoDeal_btn.setText("NoDeal");
        NoDeal_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoDeal_btnActionPerformed(evt);
            }
        });
        jPanel2.add(NoDeal_btn);
        NoDeal_btn.setBounds(370, 590, 80, 23);
        jPanel2.add(trade_pnl1);
        trade_pnl1.setBounds(10, 450, 355, 180);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(893, 40, 463, 717);

        jLabel1.setBackground(new java.awt.Color(153, 255, 153));
        jLabel1.setForeground(new java.awt.Color(204, 255, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Untitled222.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1360, 200, 30, 90);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(870, 10, 30, 220);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(870, 180, 30, 220);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(870, 360, 30, 220);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(870, 550, 30, 220);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1350, 580, 30, 220);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1350, 410, 30, 220);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1350, 250, 30, 220);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/Vmoney.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1350, 0, 30, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Cards card = new Cards();

    public void roll_Dice(Dice d) {
        switch (d.getDice_value()) {
            case 1:
                d.setImage("src/Gameplay/img/1.PNG", false);
                break;
            case 2:
                d.setImage("src/Gameplay/img/2.PNG", false);
                break;
            case 3:
                d.setImage("src/Gameplay/img/3.PNG", false);
                break;
            case 4:
                d.setImage("src/Gameplay/img/4.PNG", false);
                break;
            case 5:
                d.setImage("src/Gameplay/img/5.PNG", false);
                break;
            case 6:
                d.setImage("src/Gameplay/img/6.PNG", false);
                break;
        }
    }

    //go to jail , pay 200 income tax
    private void someConditions() {
        if (pos.getCurrentPos(player[playerTurn].getM_id()) == 4) {
            player[playerTurn].setM_balance(player[playerTurn].getM_balance() - 200);
        }
        updatePlayersBalance();
    }

    public JPanel jailPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.black, 10));
        return panel;
    }
    
   
    private void showJailPanel() throws IOException {
      //  UIManager.put("OptionPane.cancelButtonText", "Skip Turn");//2
        //UIManager.put("OptionPane.noButtonText", "Use Card");//1
        //UIManager.put("OptionPane.yesButtonText", "Pay 50$");//0
        DesitionPanel jailOpt = new JailOption();
        while (true) {
            int input = jailOpt.displayCardInfo("");
           // int input = JOptionPane.showConfirmDialog(jailPanel(), "Pay 50$ to get out of jail or Use a \"Get Out of Jail\" card or Skip your turn", "You Are In Jail!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (input == 0) {
                if (player[playerTurn].getM_balance() >= 50) {
                    player[playerTurn].setInJail(0);
                    player[playerTurn].setM_balance(player[playerTurn].getM_balance() - 50);
                    updatePlayersBalance();
                    break;
                } else {
                    try {
                        SoundEffects.PlaySound("src/Gameplay/soundEffects/you dont have enouph money.wav");
                    } catch (IOException ex) {
                        Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (input == 1) {
                if (player[playerTurn].getM_getOutOfJailCards() > 0) {
                    player[playerTurn].setInJail(0);
                    player[playerTurn].setM_getOutOfJailCards(player[playerTurn].getM_getOutOfJailCards() - 1);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "You Dont Have Cards");
                }
            } else {
                break;
            }

        }
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.yesButtonText", "Yes");

    }
    private void turnIndicator() {
        for (int i = 0; i < NumbOfPlayers; i++) {
            playerPanelAccessMap.get(i).setBorder(null);
        }
        playerPanelAccessMap.get(playerTurn).setBorder(BorderFactory.createLineBorder(Color.RED, 3));
    }
    private int WhoIsNext() {
        int i = playerTurn, cnt = 0, idx = 0;
        i %= NumbOfPlayers;
        while (true) {
            if (!player[i].isM_isLoser()) {
                return i;
            }
            i++;
            cnt++;
            if (cnt > NumbOfPlayers) {
                return 0;
            }
        }
    }
    private boolean ISAWinner() {
        int cnt = 0;
        for (int i = 0; i < NumbOfPlayers; i++) {
            if (player[i].isM_isLoser()) {
                cnt++;
            }
        }
        if (cnt == NumbOfPlayers - 1) {
            return true;
        }
        return false;
    }
     private int readFile() throws FileNotFoundException {
       int num = 0;
       try {
         File file = new File("Roll.txt");
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
           num = Integer.valueOf(scanner.nextLine());
         }
         scanner.close();
       } catch (FileNotFoundException e) {
         e.printStackTrace();
       }
       return num;
     }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        turn++;
        playerTurn++;

        playerTurn = WhoIsNext();
        playerTurn %= NumbOfPlayers;

        if (!player[playerTurn].isM_isLoser()) {

            try {
                SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_dice_end_1.wav");
            } catch (IOException ex) {
                Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
            }
            turnIndicator();

            //in jail
            if (player[playerTurn].getInJail() > 0) {
                try {
                    showJailPanel();
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (player[playerTurn].getInJail() == 0) {

                Random r = new Random();

                if (isDetectDice()){
                try {
                    if (readFile()!=0){
                        if (readFile()>6){
                            dice1.setDice_value(6);
                            dice2.setDice_value(12-6);
                        }
                        else if(readFile()<=6){
                            dice1.setDice_value(1);
                            dice2.setDice_value(readFile()-1);
                        }
                        roll_Dice(dice1);
                        roll_Dice(dice2);
                        pos.SetPlayer(playerTurn,dice1.getDice_value()+dice2.getDice_value());
                        Movement(dice1.getDice_value()+dice2.getDice_value(), player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                        s.start();
                    }
                    //dice1.getDice_value()+dice2.getDice_value()
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else {
                    jButton3.setText("Roll Dice");
                    dice1.setDice_value(r.nextInt(6) + 1);
                dice2.setDice_value(r.nextInt(6) + 1);
                roll_Dice(dice1);
                roll_Dice(dice2);
                pos.SetPlayer(playerTurn,dice1.getDice_value()+dice2.getDice_value());
                Movement(dice1.getDice_value()+dice2.getDice_value(), player[playerTurn].getM_carXY(), player[playerTurn].getM_carXY(), playerTurn);
                s.start();
                }
            } else {
                player[playerTurn].setInJail(player[playerTurn].getInJail() - 1);
            }

            checkIfZoneIsOwned(pos.getCurrentPos(player[playerTurn].getM_id()), playerTurn);
            checkBankruptcy();
            if (player[playerTurn].isM_isBankrupted()) {
                showPlayerDecisionPanel();
            }

            //   }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private void BuyCity_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyCity_btnActionPerformed
        // TODO add your handling code here:

        boolean isOwned = false;
        int index = pos.getCurrentPos(playerTurn);
        for (int i = 0; i < NumbOfPlayers; i++) {
            if (player[i].m_zonesOwnedIndexes.contains(index)) {

                //System.out.println("owned");
                isOwned = true;
                break;
            }
        }
        if (!isOwned) {

            if (zoneMap.get(index).getM_zoneCost() != 0 && player[playerTurn].getM_balance() >= zoneMap.get(index).getM_zoneCost()) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/Cash Register.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                player[playerTurn].addZone(index);
                player[playerTurn].setM_balance(player[playerTurn].getM_balance() - zoneMap.get(index).getM_zoneCost());
                updatePlayersBalance();
                //addZoneToPanel(playerTurn, zoneMap.get(index).getM_index());
                zoneMap.get(index).setPlayer_zone(player[playerTurn]);

                zoneMap.get(index).setImage(zoneMap.get(index).getPicPath(), false, true, player[playerTurn].getM_color());

                if (index == 5 || index == 13 || index == 23 || index == 33) {
                    player[playerTurn].setM_railRoadsBought(player[playerTurn].getM_railRoadsBought() + 1);
                }

                repaint();

            } else {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/you dont have enouph money.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }//GEN-LAST:event_BuyCity_btnActionPerformed

    private void playerPanelAccsessMapInitialization() {
        playerPanelAccessMap = new HashMap<Integer, Player_pnl>();
        playerPanelAccessMap.put(0, player_pnl1);
        playerPanelAccessMap.put(1, player_pnl2);
        playerPanelAccessMap.put(2, player_pnl3);
        playerPanelAccessMap.put(3, player_pnl4);
        playerPanelAccessMap.put(4, player_pnl5);
        playerPanelAccessMap.put(5, player_pnl6);

    }

    private static JPanel getCardInfoPanel(String Path) {
        JPanel panel = new JPanel();

        String path = Path;
        Image img = null;
        try {
            File imgFile = new File(path);
            img = ImageIO.read(imgFile);
            panel.setBorder(new LineBorder(Color.black, 7));

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        JLabel label = new JLabel(new ImageIcon(img));
        panel.add(label);

        return panel;
    }

    private JPanel playerDecisionPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.black, 10));
        return panel;
    }

    public void showPlayerDecisionPanel() {

        UIManager.put("OptionPane.noButtonText", "Leave Game"); //1
        UIManager.put("OptionPane.yesButtonText", "Sell City or Buildings");//0

        int input = JOptionPane.showConfirmDialog(playerDecisionPanel(), "You Are Bankrupted Decide Wether To Sell City Or Leave The Game!", "DECIDE!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (input == 0) {
            if (player[playerTurn].m_zonesOwnedIndexes.size() > 0) {

            } else {
                player[playerTurn].setM_isLoser(true);
            }
        } else if (input == 1) {
            int x = playerTurn;
            for (int i = 0; i < player[x].m_zonesOwnedIndexes.size(); i++) {
                int v = player[x].m_zonesOwnedIndexes.get(i);
                zoneMap.get(v).remove(2);
                zoneMap.get(v).setImage(zoneMap.get(v).getPicPath(), true, false, null);
                zoneMap.get(v).setPlayer_zone(null);  // 3lshan a5li ay 7d tani mmkn yshtreha
                jPanel1.repaint();
            }
            player[x].m_zonesOwnedIndexes.removeAll(player[x].m_zonesOwnedIndexes);

            player[playerTurn].setM_isLoser(true);
            turn++;

        }

        SetPanelToWinner();

        playerTurn %= NumbOfPlayers;

        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.yesButtonText", "Yes");
        jPanel1.repaint();

    }

    private void checkBankruptcy() {
        for (int i = 0; i < NumbOfPlayers; i++) {
            if (player[i].getM_balance() < 0) {
                player[i].setM_isBankrupted(true);
            }
        }

    }

    public int finally_winner() {
        int index = -1;
        if (ISAWinner()) {
            for (int i = 0; i < NumbOfPlayers; i++) {
                if (!player[i].isM_isLoser()) {
                    index = i;
                }
            }
        }
        return index;
    }

    public void SetPanelToWinner() {
        if (ISAWinner()) {
            try {
                SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_wingame.wav");
            } catch (IOException ex) {
                Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
            }
            int y = finally_winner();
            if (y != -1) {
                switch (y) {
                    case 0:
                        winner_lbl0.setVisible(true);
                        winnerpic_lbl0.setVisible(true);
                        break;
                    case 1:
                        winner_lbl1.setVisible(true);
                        winnerpic_lbl1.setVisible(true);
                        break;
                    case 2:
                        winner_lbl2.setVisible(true);
                        winnerpic_lbl2.setVisible(true);
                        break;
                    case 3:
                        winner_lbl3.setVisible(true);
                        winnerpic_lbl3.setVisible(true);
                        break;
                    case 4:
                        winner_lbl4.setVisible(true);
                        winnerpic_lbl4.setVisible(true);
                        break;
                    case 5:
                        winner_lbl5.setVisible(true);
                        winnerpic_lbl5.setVisible(true);
                        break;

                }
            }
            gameOver1.setLocation(new Point(0, 0));
            DisEnabelEveryThing();
            PlayAgainBtn.setVisible(true);
            PlayAgainBtn.setLocation(new Point(620, 629));
            Exit.setLocation(new Point(620, 629 + PlayAgainBtn.getHeight() + 10));
        }
    }

    public boolean BuidHotel(int playerTurn) {
        for (int i = 0; i < player[playerTurn].m_zonesOwnedIndexes.size(); i++) {
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 1 && player[playerTurn].m_zonesOwnedIndexes.get(i + 1) == 3) {
                    if (pos.getCurrentPos(playerTurn) == 1 || pos.getCurrentPos(playerTurn) == 3) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 6 && player[playerTurn].m_zonesOwnedIndexes.get(i + 1) == 8 && player[playerTurn].m_zonesOwnedIndexes.get(i + 2) == 9) {
                    if (pos.getCurrentPos(playerTurn) == 6 || pos.getCurrentPos(playerTurn) == 8 || pos.getCurrentPos(playerTurn) == 9) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 11 && player[playerTurn].m_zonesOwnedIndexes.get(i + 1) == 12) {
                    if (pos.getCurrentPos(playerTurn) == 11 || pos.getCurrentPos(playerTurn) == 12) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 14 && player[playerTurn].m_zonesOwnedIndexes.get(i + 1) == 16 && player[playerTurn].m_zonesOwnedIndexes.get(i + 2) == 17) {
                    if (pos.getCurrentPos(playerTurn) == 14 || pos.getCurrentPos(playerTurn) == 16 || pos.getCurrentPos(playerTurn) == 17) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 19 && player[playerTurn].m_zonesOwnedIndexes.get(i + 1) == 21 && player[playerTurn].m_zonesOwnedIndexes.get(i + 2) == 22) {
                    if (pos.getCurrentPos(playerTurn) == 19 || pos.getCurrentPos(playerTurn) == 21 || pos.getCurrentPos(playerTurn) == 22) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 24 && player[playerTurn].m_zonesOwnedIndexes.get(i + 1) == 25 && player[playerTurn].m_zonesOwnedIndexes.get(i + 2) == 27) {
                    if (pos.getCurrentPos(playerTurn) == 24 || pos.getCurrentPos(playerTurn) == 25 || pos.getCurrentPos(playerTurn) == 27) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 29 && player[playerTurn].m_zonesOwnedIndexes.get(i + 1) == 30 && player[playerTurn].m_zonesOwnedIndexes.get(i + 2) == 32) {
                    if (pos.getCurrentPos(playerTurn) == 29 || pos.getCurrentPos(playerTurn) == 30 || pos.getCurrentPos(playerTurn) == 32) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if (player[playerTurn].m_zonesOwnedIndexes.get(i) == 35) {
                    if (pos.getCurrentPos(playerTurn) == 35) {
                        return true;
                    }
                }

            } catch (Exception e) {
            }
            try {
                if ((player[playerTurn].m_zonesOwnedIndexes.get(i) == 5 && pos.getCurrentPos(playerTurn) == 5)
                        || (player[playerTurn].m_zonesOwnedIndexes.get(i) == 13 && pos.getCurrentPos(playerTurn) == 13)
                        || (player[playerTurn].m_zonesOwnedIndexes.get(i) == 23 && pos.getCurrentPos(playerTurn) == 23)
                        || (player[playerTurn].m_zonesOwnedIndexes.get(i) == 33 && pos.getCurrentPos(playerTurn) == 33)) {

                    return true;
                }

            } catch (Exception e) {
            }
        }
        return false;
    }

    public void UpdateBuildings(int CityIdx, Color color) {
        for (Map.Entry<Integer, Zone> entry : zoneMap.entrySet()) {
            int key = entry.getKey();
            Object value = entry.getValue();
            if ((key > 0 && key < 10) || (key > 18 && key < 28)) {
                try {
                    if (build.containsKey(CityIdx)) {
                        HBuildings HB = (HBuildings) build.get(CityIdx);
                        //HB.setNumAndColor(zoneMap.get(CityIdx).getM_NumOFBuildedHouses(), player[playerTurn].getM_color(), false);
                        HB.setNumAndColor(zoneMap.get(CityIdx).getM_NumOFBuildedHouses(), color, false);
                        if (color != null && zoneMap.get(CityIdx).getM_NumOFBuildedHouses() > 0) {
                            HB.setVisible(true);
                        } else {
                            HB.setVisible(false);
                        }
                    }
                } catch (Exception e) {
                }

            } else {
                try {
                    if (build.containsKey(CityIdx)) {
                        VBuidings VB = (VBuidings) build.get(CityIdx);
                        VB.setNumAndColor(zoneMap.get(CityIdx).getM_NumOFBuildedHouses(), color, false);
                        if (color != null && zoneMap.get(CityIdx).getM_NumOFBuildedHouses() > 0) {
                            VB.setVisible(true);
                        } else {
                            VB.setVisible(false);
                        }
                    }
                } catch (Exception e) {
                }

            }
        }
        repaint();
    }
    
    private void Trade_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Trade_btnActionPerformed
        // TODO add your handling code here:

        Zone z = zoneMap.get(pos.getCurrentPos(player[playerTurn].getM_id()));
        Player p = z.getPlayer_zone();

        if (z.getPlayer_zone() != null && !player[playerTurn].m_zonesOwnedIndexes.contains(pos.getCurrentPos(player[playerTurn].getM_id()))) {

            trade_pnl1.setVisible(true);
            Deal_btn.setVisible(true);
            NoDeal_btn.setVisible(true);
            trade_pnl1.getId_lbl1().setText(String.valueOf(player[playerTurn].getM_id()));
            trade_pnl1.getId_lbl2().setText(String.valueOf(p.getM_id()));

            trade_pnl1.validate();
            trade_pnl1.repaint();
        }
    }//GEN-LAST:event_Trade_btnActionPerformed

    private void Build_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Build_btnActionPerformed
        // TODO add your handling code here:
        int idx = pos.getCurrentPos(playerTurn);
        if (idx != 5 && idx != 13 && idx != 23 && idx != 33) {
            for (int i = 0; i < player[playerTurn].m_zonesOwnedIndexes.size(); i++) {
                int currentBalance = player[playerTurn].getM_balance();
                int HouseCost = zoneMap.get(pos.getCurrentPos(playerTurn)).getM_houseCost();
                int Cityidx = player[playerTurn].m_zonesOwnedIndexes.get(i);
                if (idx == Cityidx) {
                    if ((currentBalance > HouseCost) && BuidHotel(playerTurn)) {

                        int ToBeBuild = zoneMap.get(Cityidx).getM_NumOFBuildedHouses() + 1;

                        if (((idx > 0 && idx < 10) || (idx > 18 && idx < 28)) && (!zoneMap.get(Cityidx).isHotelBuilded())) {
                            
                            HBuildings HB = (HBuildings) build.get(idx);

                            if (ToBeBuild <= 5 && BuidHotel(playerTurn)) {
                                try {
                                    SoundEffects.PlaySound("src/Gameplay/soundEffects/zapsplat_impacts_wood.wav");
                                } catch (IOException ex) {
                                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                zoneMap.get(Cityidx).setM_NumOFBuildedHouses((zoneMap.get(Cityidx).getM_NumOFBuildedHouses()) + 1);
                                if (ToBeBuild <= 4) {
                                    HB.setNumAndColor(zoneMap.get(Cityidx).getM_NumOFBuildedHouses(), player[playerTurn].getM_color(), false);
                                    player[playerTurn].setM_numberOfHouses(player[playerTurn].getM_numberOfHouses() + 1);
                                } else {
                                    HB.setNumAndColor(zoneMap.get(Cityidx).getM_NumOFBuildedHouses(), player[playerTurn].getM_color(), true);
                                    zoneMap.get(Cityidx).setHotelBuilded(true);
                                    player[playerTurn].setM_numberOfHouses(player[playerTurn].getM_numberOfHouses() - 4);
                                    player[playerTurn].setM_numberOFHotels(player[playerTurn].getM_numberOFHotels() + 1);
                                }
                                HB.setVisible(true);
                                build.replace(idx, HB);
                                player[playerTurn].setM_balance(currentBalance - zoneMap.get(Cityidx).getM_houseCost());
                                break;
                            }
                        } else {
                            if (!zoneMap.get(Cityidx).isHotelBuilded()) {

                                VBuidings VB = (VBuidings) build.get(idx);

                                if (ToBeBuild <= 5 && BuidHotel(playerTurn) == true) {
                                    try {
                                        SoundEffects.PlaySound("src/Gameplay/soundEffects/zapsplat_impacts_wood.wav");
                                    } catch (IOException ex) {
                                        Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    zoneMap.get(Cityidx).setM_NumOFBuildedHouses((zoneMap.get(Cityidx).getM_NumOFBuildedHouses()) + 1);
                                    if (ToBeBuild <= 4) {
                                        VB.setNumAndColor(zoneMap.get(Cityidx).getM_NumOFBuildedHouses(), player[playerTurn].getM_color(), false);
                                        player[playerTurn].setM_numberOfHouses(player[playerTurn].getM_numberOfHouses() + 1);
                                    } else {
                                        VB.setNumAndColor(zoneMap.get(Cityidx).getM_NumOFBuildedHouses(), player[playerTurn].getM_color(), true);
                                        zoneMap.get(Cityidx).setHotelBuilded(true);
                                        player[playerTurn].setM_numberOfHouses(player[playerTurn].getM_numberOfHouses() - 4);
                                        player[playerTurn].setM_numberOFHotels(player[playerTurn].getM_numberOFHotels() + 1);
                                    }
                                    VB.setVisible(true);
                                    build.replace(idx, VB);
                                    player[playerTurn].setM_balance(currentBalance - zoneMap.get(Cityidx).getM_houseCost());
                                    break;
                                }

                            }
                        }
                    } else if (currentBalance < HouseCost) {
                        try {
                            SoundEffects.PlaySound("src/Gameplay/soundEffects/you dont have enouph money.wav");
                        } catch (IOException ex) {
                            Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
            }
        }

        updatePlayersBalance();
        repaint();
    }//GEN-LAST:event_Build_btnActionPerformed

    private void Deal_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Deal_btnActionPerformed
        // TODO add your handling code here:

        Zone z = zoneMap.get(pos.getCurrentPos(player[playerTurn].getM_id()));
        Player p = z.getPlayer_zone();

        //  if(!player[playerTurn].m_zonesOwnedIndexes.contains(pos.getCurrentPos(player[playerTurn].getM_id()))){
        if (p.m_zonesOwnedIndexes.contains(z.getM_index())) {
            if (player[playerTurn].getM_balance() >= Integer.valueOf(trade_pnl1.getMoney_txt().getText())) {
                p.setM_balance(p.getM_balance() + Integer.valueOf(trade_pnl1.getMoney_txt().getText()));
                player[playerTurn].setM_balance(player[playerTurn].getM_balance() - Integer.valueOf(trade_pnl1.getMoney_txt().getText()));
                int cityindex = 0;
                for (int i = 0; i < p.m_zonesOwnedIndexes.size(); i++) {
                    if (p.m_zonesOwnedIndexes.contains(z.getM_index())) {
                        cityindex = i;
                    }
                }
                p.m_zonesOwnedIndexes.remove(cityindex);
                player[playerTurn].addZone(z.getM_index());
                zoneMap.get(z.getM_index()).setPlayer_zone(player[playerTurn]);

                updatePlayersBalance();

                if (z.getM_index() == 5 || z.getM_index() == 13 || z.getM_index() == 23 || z.getM_index() == 33) {
                    zoneMap.get(z.getM_index()).remove(1);
                    zoneMap.get(z.getM_index()).setImage(z.getPicPath(), true, true, player[playerTurn].getM_color());
                } else {
                    zoneMap.get(z.getM_index()).remove(2);
                    zoneMap.get(z.getM_index()).setImage(z.getPicPath(), true, true, player[playerTurn].getM_color());
                }
                UpdateBuildings(z.getM_index(), player[playerTurn].getM_color());
                jPanel1.repaint();

                trade_pnl1.setVisible(false);
                Deal_btn.setVisible(false);
                NoDeal_btn.setVisible(false);
            } else {
                trade_pnl1.setVisible(true);
                Deal_btn.setVisible(true);
                NoDeal_btn.setVisible(true);
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/you dont have enouph money.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Deal_btnActionPerformed

    private void NoDeal_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoDeal_btnActionPerformed
        // TODO add your handling code here:
        trade_pnl1.setVisible(false);
        Deal_btn.setVisible(false);
        NoDeal_btn.setVisible(false);
    }//GEN-LAST:event_NoDeal_btnActionPerformed

    private void PlayAgainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayAgainBtnActionPerformed
        // TODO add your handling code here:
        //SingletoneGamePlay.setSingleInstance(null);
        StartScreen sc = new StartScreen();
        sc.setIsPlayAgain(true);
        sc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PlayAgainBtnActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        try {
            // TODO add your handling code here:
            SaveGame save = new SaveGame(player, NumbOfPlayers, pos);
            save.SaveToFile();
        } catch (IOException ex) {
            Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Gameplay().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public Zone getAtlantic() {
        return Atlantic;
    }

    public Zone getBaltic() {
        return Baltic;
    }

    public Zone getCCT() {
        return CCT;
    }

    public Zone getChanceBlue() {
        return ChanceBlue;
    }

    public Zone getChanceRed() {
        return ChanceRed;
    }

    public Zone getCommunity_Chest() {
        return Community_Chest;
    }

    public Zone getConnecticut() {
        return Connecticut;
    }

    public Zone getIllinois() {
        return Illinois;
    }

    public Zone getIncomeTax() {
        return IncomeTax;
    }

    public Zone getIndiana() {
        return Indiana;
    }

    public Zone getKentucky() {
        return Kentucky;
    }

    public Zone getMONOMAN() {
        return MONOMAN;
    }

    public Zone getMarvinGardens() {
        return MarvinGardens;
    }

    public Zone getMediter_Ranean() {
        return Mediter_Ranean;
    }

    public Zone getNewYork() {
        return NewYork;
    }

    public Zone getNorthCaro() {
        return NorthCaro;
    }

    public Zone getOrangeChance() {
        return OrangeChance;
    }

    public Zone getOriental() {
        return Oriental;
    }

    public Zone getParkPlace() {
        return ParkPlace;
    }

    public Zone getRailRoad() {
        return RailRoad;
    }

    public Zone getRealRoad() {
        return RealRoad;
    }

    public Zone getStates() {
        return States;
    }

    public Zone getTenss() {
        return Tenss;
    }

    public Zone getVermont() {
        return Vermont;
    }

    public Zone getVirginnia() {
        return Virginnia;
    }

    public Zone getBluetreasure() {
        return bluetreasure;
    }

    public Zone getCommuntityChestRight() {
        return communtityChestRight;
    }

    public Zone getGo() {
        return go;
    }

    public Zone getGoToJail() {
        return goToJail;
    }

    public Zone getJail() {
        return jail;
    }

    public Zone getOrange() {
        return orange;
    }

    public Zone getPacific() {
        return pacific;
    }

    public Zone getParking() {
        return parking;
    }

    public Zone getPennsy() {
        return pennsy;
    }

    public Zone getPennsyl() {
        return pennsyl;
    }

    public Zone getShorLline() {
        return shorLline;
    }

    public Zone getStJames() {
        return stJames;
    }

    public Zone getVentnor() {
        return ventnor;
    }

    public Zone getWaterWorks() {
        return waterWorks;
    }

    public int getTurn() {
        return turn;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GamePlay0.Zone Atlantic;
    private Buildings.HBuildings B1;
    private Buildings.VBuidings B11;
    private Buildings.VBuidings B12;
    private Buildings.VBuidings B14;
    private Buildings.VBuidings B16;
    private Buildings.VBuidings B17;
    private Buildings.HBuildings B19;
    private Buildings.HBuildings B21;
    private Buildings.HBuildings B22;
    private Buildings.HBuildings B24;
    private Buildings.HBuildings B25;
    private Buildings.HBuildings B27;
    private Buildings.VBuidings B29;
    private Buildings.HBuildings B3;
    private Buildings.VBuidings B30;
    private Buildings.VBuidings B32;
    private Buildings.VBuidings B35;
    private Buildings.HBuildings B6;
    private Buildings.HBuildings B8;
    private Buildings.HBuildings B9;
    private GamePlay0.Zone Baltic;
    private javax.swing.JButton Build_btn;
    private javax.swing.JButton BuyCity_btn;
    private GamePlay0.Zone CCT;
    private GamePlay0.Zone ChanceBlue;
    private GamePlay0.Zone ChanceRed;
    private GamePlay0.Zone Community_Chest;
    private GamePlay0.Zone Connecticut;
    private javax.swing.JButton Deal_btn;
    private javax.swing.JButton Exit;
    private GamePlay0.Zone Illinois;
    private GamePlay0.Zone IncomeTax;
    private GamePlay0.Zone Indiana;
    private GamePlay0.Zone Kentucky;
    private GamePlay0.Zone MONOMAN;
    private GamePlay0.Zone MarvinGardens;
    private GamePlay0.Zone Mediter_Ranean;
    private GamePlay0.Zone NewYork;
    private javax.swing.JButton NoDeal_btn;
    private GamePlay0.Zone NorthCaro;
    private GamePlay0.Zone OrangeChance;
    private GamePlay0.Zone Oriental;
    private GamePlay0.Zone ParkPlace;
    private javax.swing.JButton PlayAgainBtn;
    private GamePlay0.Zone RailRoad;
    private GamePlay0.Zone RealRoad;
    private javax.swing.JButton Save;
    private GamePlay0.Zone States;
    private GamePlay0.Zone Tenss;
    private javax.swing.JButton Trade_btn;
    private GamePlay0.Zone Vermont;
    private GamePlay0.Zone Virginnia;
    private GamePlay0.Zone bluetreasure;
    private GamePlay0.Zone communtityChestRight;
    private GamePlay0.Dice dice1;
    private GamePlay0.Dice dice2;
    private NewGame.GameOver gameOver1;
    private GamePlay0.Zone go;
    private GamePlay0.Zone goToJail;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private GamePlay0.Zone jail;
    private GamePlay0.Zone orange;
    private GamePlay0.Zone pacific;
    private GamePlay0.Zone parking;
    private GamePlay0.Zone pennsy;
    private GamePlay0.Zone pennsyl;
    private GamePlay0.Player_pnl player_pnl1;
    private GamePlay0.Player_pnl player_pnl2;
    private GamePlay0.Player_pnl player_pnl3;
    private GamePlay0.Player_pnl player_pnl4;
    private GamePlay0.Player_pnl player_pnl5;
    private GamePlay0.Player_pnl player_pnl6;
    private GamePlay0.Zone shorLline;
    private GamePlay0.Zone stJames;
    private GamePlay0.trade_pnl trade_pnl1;
    private GamePlay0.Zone ventnor;
    private GamePlay0.Zone waterWorks;
    private javax.swing.JLabel winner_lbl0;
    private javax.swing.JLabel winner_lbl1;
    private javax.swing.JLabel winner_lbl2;
    private javax.swing.JLabel winner_lbl3;
    private javax.swing.JLabel winner_lbl4;
    private javax.swing.JLabel winner_lbl5;
    private javax.swing.JLabel winnerpic_lbl0;
    private javax.swing.JLabel winnerpic_lbl1;
    private javax.swing.JLabel winnerpic_lbl2;
    private javax.swing.JLabel winnerpic_lbl3;
    private javax.swing.JLabel winnerpic_lbl4;
    private javax.swing.JLabel winnerpic_lbl5;
    // End of variables declaration//GEN-END:variables

    // i = owner , id = elly bydfa3 el rent
    private void checkIfZoneIsOwned(int position, int id) {
        for (int i = 0; i < NumbOfPlayers; i++) {
            if (player[i].m_zonesOwnedIndexes.contains(position)) {
                int totalBuildings = zoneMap.get(position).getM_NumOFBuildedHouses();
                int totalRent = 0;
                if (pos.getCurrentPos(player[id].getM_id()) == 5 || pos.getCurrentPos(player[id].getM_id()) == 13 || pos.getCurrentPos(player[id].getM_id()) == 23 || pos.getCurrentPos(player[id].getM_id()) == 33) {
                    if (player[i].getM_railRoadsBought() == 1) {
                        totalRent = zoneMap.get(position).getM_rent();
                    } else if (player[i].getM_railRoadsBought() == 2) {
                        totalRent = zoneMap.get(position).getM_rentWithColorSet();
                    } else if (player[i].getM_railRoadsBought() == 3) {
                        totalRent = zoneMap.get(position).getM_rentWithOneHouse();
                    } else if (player[i].getM_railRoadsBought() == 4) {
                        totalRent = zoneMap.get(position).getM_rentWithTwoHouses();
                    }
                } else if (pos.getCurrentPos(player[id].getM_id()) != 26) {
                    switch (totalBuildings) {
                        case 0:
                            totalRent = zoneMap.get(position).getM_rent();
                            if (BuidHotel(i)) {
                                totalRent = zoneMap.get(position).getM_rentWithColorSet();
                            }
                            break;
                        case 1:
                            totalRent = zoneMap.get(position).getM_rentWithOneHouse();
                            break;
                        case 2:
                            totalRent = zoneMap.get(position).getM_rentWithTwoHouses();
                            break;

                        case 3:
                            totalRent = zoneMap.get(position).getM_rentWithThreeHouses();
                            break;

                        case 4:
                            totalRent = zoneMap.get(position).getM_rentWithFourHouses();
                            break;

                        case 5:
                            totalRent = zoneMap.get(position).getM_rentWithHotel();
                            break;
                    }
                } else if (pos.getCurrentPos(id) == 26) {
                    totalRent = zoneMap.get(position).getM_rent() * (dice1.getDice_value() + dice2.getDice_value());

                }
                player[i].setM_balance(player[i].getM_balance() + totalRent);
                player[id].setM_balance(player[id].getM_balance() - totalRent);
                updatePlayersBalance();
            }
        }
    }

}
