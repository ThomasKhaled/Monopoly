package GamePlay0;

import Playerpkg.SellOption;
import Playerpkg.Player;
import Playerpkg.DesitionPanel;
import static GamePlay0.Gameplay.playerTurn;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class zoneEvents {

    private Gameplay g ;
    private Player []player;
    private Map<Integer, Zone> zoneMap;
    private static int Res;
    private int turn;
    private static DesitionPanel destion;
    
    
    public zoneEvents() throws IOException{
       g = SingletoneGamePlay.getInstance(false);
       destion = new SellOption();
       UpdateData();
    }
    private void UpdateData(){
        player = g.getPlayer();
        zoneMap = g.getZoneMap();
        turn = 1;
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
    
    private static void displayCardInfo(String Path) {
        JOptionPane.showConfirmDialog(null,
                
                getCardInfoPanel(Path),
                "Card Info  ",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }
    

    private void SetSellOption(int Res, int cityIDx) {

        if (Res == 1) {//sell
            g.UpdateBuildings(cityIDx, null);
            player[playerTurn].setM_balance(player[playerTurn].getM_balance()
                    + (zoneMap.get(cityIDx).getM_zoneCost() / 2)
                    + (zoneMap.get(cityIDx).getM_NumOFBuildedHouses() * zoneMap.get(cityIDx).getM_houseCost()) / 2);
            if (zoneMap.get(cityIDx).getM_NumOFBuildedHouses() == 5) {
                player[playerTurn].setM_numberOFHotels(player[playerTurn].getM_numberOFHotels() - 1);
            } else {
                player[playerTurn].setM_numberOfHouses(player[playerTurn].getM_numberOfHouses()
                        - zoneMap.get(cityIDx).getM_NumOFBuildedHouses());
            }

            zoneMap.get(cityIDx).setM_NumOFBuildedHouses(0);
            zoneMap.get(cityIDx).setHotelBuilded(false);
            player[playerTurn].m_zonesOwnedIndexes.remove(new Integer(zoneMap.get(cityIDx).getM_index()));
            if (cityIDx == 5 || cityIDx == 13 || cityIDx == 23 || cityIDx == 33) {
                zoneMap.get(cityIDx).remove(1);
            } else {
                zoneMap.get(cityIDx).remove(2);
            }
            zoneMap.get(cityIDx).setImage(zoneMap.get(cityIDx).getPicPath(), true, false, null);
            zoneMap.get(cityIDx).setBought(false);
            if (cityIDx == 5 || cityIDx == 13 || cityIDx == 23 || cityIDx == 33) {
                player[playerTurn].setM_railRoadsBought(player[playerTurn].getM_railRoadsBought() - 1);
            }

        } else if (Res == 0) {
            g.UpdateBuildings(cityIDx, null);
            player[playerTurn].setM_balance(player[playerTurn].getM_balance()
                    + (zoneMap.get(cityIDx).getM_NumOFBuildedHouses() * zoneMap.get(cityIDx).getM_houseCost()) / 2);

            if (zoneMap.get(cityIDx).getM_NumOFBuildedHouses() == 5) {
                player[playerTurn].setM_numberOFHotels(player[playerTurn].getM_numberOFHotels() - 1);
            } else {
                player[playerTurn].setM_numberOfHouses(player[playerTurn].getM_numberOfHouses()
                        - zoneMap.get(cityIDx).getM_NumOFBuildedHouses());
            }

            zoneMap.get(cityIDx).setM_NumOFBuildedHouses(0);
            zoneMap.get(cityIDx).setHotelBuilded(false);

        }

        if (player[playerTurn].getM_balance() > 0 || player[playerTurn].m_zonesOwnedIndexes.size() > 0 || player[playerTurn].getM_numberOfHouses() > 0) {
            player[playerTurn].setM_isBankrupted(false);
        } else {
            player[playerTurn].setM_isLoser(true);
        }

        if (player[playerTurn].m_zonesOwnedIndexes.size() > 0 && player[playerTurn].getM_balance() < 0) {
            g.showPlayerDecisionPanel();
        }

        g.updatePlayersBalance();

        g.getjPanel1().repaint();

        g.SetPanelToWinner();

    }
    

    
    public void DisplayCiyInfo() {
        UpdateData();
        // cards info mouse events
        g.getMarvinGardens().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getMarvinGardens().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/MarvinGardens.png");
                    SetSellOption(Res, g.getMarvinGardens().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/MarvinGardens.png");
                }

            }
        });

        g.getVentnor().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getVentnor().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/VentorAvenue.png");
                    SetSellOption(Res, g.getVentnor().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/VentorAvenue.png");
                }
            }
        });

        g.getAtlantic().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.

                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getAtlantic().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/AtlanticAvenue.png");
                    SetSellOption(Res, g.getAtlantic().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/AtlanticAvenue.png");
                }
            }
        });

        g.getIllinois().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getIllinois().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/IllinoisAvenue.png");
                    SetSellOption(Res, g.getIllinois().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/IllinoisAvenue.png");
                }
            }
        });

        g.getIndiana().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getIndiana().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/IndianaAvenue.png");
                    SetSellOption(Res, g.getIndiana().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/IndianaAvenue.png");
                }
            }
        });

        g.getKentucky().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getKentucky().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/KentuckyAvenue.png");
                    SetSellOption(Res, g.getKentucky().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/KentuckyAvenue.png");
                }

            }
        });

        g.getMediter_Ranean().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                
                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getMediter_Ranean().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/MediteraneanAvenue.png");
                    SetSellOption(Res, g.getMediter_Ranean().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/MediteraneanAvenue.png");
                }
            }
        });

        g.getBaltic().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getBaltic().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/BalticAvenue.png");
                    SetSellOption(Res, g.getBaltic().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/BalticAvenue.png");
                }
            }
        });

        g.getOriental().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getOriental().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/OrientalAvenue.png");
                    SetSellOption(Res, g.getOriental().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/OrientalAvenue.png");
                }
            }
        });

        g.getVermont().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getVermont().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/VermontAvenue.png");
                    SetSellOption(Res, g.getVermont().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/VermontAvenue.png");
                }
            }
        });

        g.getConnecticut().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getConnecticut().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/ConnectCutAvenue.png");
                    SetSellOption(Res, g.getConnecticut().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/ConnectCutAvenue.png");
                }
            }
        });

        g.getPacific().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getPacific().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/PacificAvenue.png");
                    SetSellOption(Res, g.getPacific().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/PacificAvenue.png");
                }
            }
        });

        g.getNorthCaro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn>0 &&player[playerTurn].m_zonesOwnedIndexes.contains(g.getNorthCaro().getM_index())){
                    Res =destion.displayCardInfo("src/Gameplay/img/cards/NorthCarolina.png");
                    SetSellOption(Res,g.getNorthCaro().getM_index());
                }
                else
                    displayCardInfo("src/Gameplay/img/cards/NorthCarolina.png");
            }
        });
        


        g.getPennsy().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn != 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getPennsy().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/Pensylvania.png");
                    SetSellOption(Res, g.getPennsy().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/Pensylvania.png");
                }
            }
        });

        g.getParkPlace().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getParkPlace().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/ParkPlace.png");
                    SetSellOption(Res, g.getParkPlace().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/ParkPlace.png");
                }
            }
        });

        g.getNewYork().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getNewYork().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/NewYorkAvenue.png");
                    SetSellOption(Res, g.getNewYork().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/NewYorkAvenue.png");
                }
            }
        });

        g.getTenss().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getTenss().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/TennesseeAvenue.png");
                    SetSellOption(Res, g.getTenss().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/TennesseeAvenue.png");
                }
            }
        });

        g.getStJames().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getStJames().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/StJamesPlace.png");
                    SetSellOption(Res, g.getStJames().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/StJamesPlace.png");
                }
            }
        });

        g.getVirginnia().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }

                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 1 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getVirginnia().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/VirginiaAvenue.png");
                    SetSellOption(Res, g.getVirginnia().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/VirginiaAvenue.png");
                }
            }
        });

        g.getStates().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getStates().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/StatesAvenue.png");
                    SetSellOption(Res, g.getStates().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/StatesAvenue.png");
                }
            }
        });

        g.getRealRoad().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getRealRoad().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/RR.png");
                    SetSellOption(Res, g.getRealRoad().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/RR.png");
                }
            }
        });
        g.getRailRoad().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getRailRoad())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/RR.png");
                    SetSellOption(Res, g.getRailRoad().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/RR.png");
                }
            }
        });

        g.getPennsyl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getPennsyl().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/PR.png");
                    SetSellOption(Res, g.getPennsyl().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/PR.png");
                }
            }
        });

        g.getShorLline().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getShorLline().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/SL.png");
                    SetSellOption(Res, g.getShorLline().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/SL.png");
                }
            }
        });
        g.getWaterWorks().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    SoundEffects.PlaySound("src/Gameplay/soundEffects/snd_sys_select.wav");
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                if (turn > 0 && player[playerTurn].m_zonesOwnedIndexes.contains(g.getWaterWorks().getM_index())) {
                    Res = destion.displayCardInfo("src/Gameplay/img/cards/WW.png");
                    SetSellOption(Res, g.getWaterWorks().getM_index());
                } else {
                    displayCardInfo("src/Gameplay/img/cards/WW.png");
                }
            }
        });

        //this.repaint();
    }
}
