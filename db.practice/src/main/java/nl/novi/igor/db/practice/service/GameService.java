package nl.novi.igor.db.practice.service;

import nl.novi.igor.db.practice.dto.Game;
import nl.novi.igor.db.practice.dto.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class GameRowMapper implements RowMapper<Game> {
        @Override
        public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
            Game game = new Game();
            game.setId(rs.getLong("id"));
            game.setPlayerWon(findById(rs.getLong("player_won_id")));
            return game;
        }
    }

    public Player findById(long id) {
        return jdbcTemplate.queryForObject("select * from players where id=?", new Object[] { id },
                new BeanPropertyRowMapper<Player>(Player.class));
    }

    public List<Game> getAllGames() {
        return jdbcTemplate.query("select * from games", new GameRowMapper());
    }
}
