package nl.novi.igor.db.practice.dto;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "GAMES")
@Check(constraints = "(PLAYER_ONE_ID = PLAYER_WON_ID OR PLAYER_TWO_ID = PLAYER_WON_ID) AND PLAYER_ONE_ID <> PLAYER_TWO_ID")
public class Game {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ONE_ID", referencedColumnName = "id")
    private Player playerOne;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_TWO_ID", referencedColumnName = "id")
    private Player playerTwo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_WON_ID", referencedColumnName = "id")
    private Player playerWon;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "DATE_PLAYED")
    private Date datePlayed;

    @Column(name = "TIME_PLAYED")
    private Time timePlayed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Player getPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(Player playerWon) {
        this.playerWon = playerWon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Date datePlayed) {
        this.datePlayed = datePlayed;
    }

    public Time getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(Time timePlayed) {
        this.timePlayed = timePlayed;
    }
}
