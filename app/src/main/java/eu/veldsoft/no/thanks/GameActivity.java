package eu.veldsoft.no.thanks;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.veldsoft.no.thanks.model.Table;

/**
 * Main game screen.
 */
public class GameActivity extends AppCompatActivity {
    /**
     * Map of the card key and card image.
     */
    static final Map<String, Integer> CARDS_IMAGES = new HashMap<String, Integer>();
    /**
     * The identifier for launching activity.
     */
    private static final int LAUNCH_PLAYERS_LIST_ACTIVITY = 1;
    /**
     * Table object as mediator with the model.
     */
    private Table table = new Table();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /*
         * Map card keys to card image resource identifiers.
         */
        if (CARDS_IMAGES.size() == 0) {
            CARDS_IMAGES.put("00", R.drawable.background);
            CARDS_IMAGES.put("03", R.drawable.card03);
            CARDS_IMAGES.put("04", R.drawable.card04);
            CARDS_IMAGES.put("05", R.drawable.card05);
            CARDS_IMAGES.put("06", R.drawable.card06);
            CARDS_IMAGES.put("07", R.drawable.card07);
            CARDS_IMAGES.put("08", R.drawable.card08);
            CARDS_IMAGES.put("09", R.drawable.card09);
            CARDS_IMAGES.put("10", R.drawable.card10);
            CARDS_IMAGES.put("11", R.drawable.card11);
            CARDS_IMAGES.put("12", R.drawable.card12);
            CARDS_IMAGES.put("13", R.drawable.card13);
            CARDS_IMAGES.put("14", R.drawable.card14);
            CARDS_IMAGES.put("15", R.drawable.card15);
            CARDS_IMAGES.put("16", R.drawable.card16);
            CARDS_IMAGES.put("17", R.drawable.card17);
            CARDS_IMAGES.put("18", R.drawable.card18);
            CARDS_IMAGES.put("19", R.drawable.card19);
            CARDS_IMAGES.put("20", R.drawable.card20);
            CARDS_IMAGES.put("21", R.drawable.card21);
            CARDS_IMAGES.put("22", R.drawable.card22);
            CARDS_IMAGES.put("23", R.drawable.card23);
            CARDS_IMAGES.put("24", R.drawable.card24);
            CARDS_IMAGES.put("25", R.drawable.card25);
            CARDS_IMAGES.put("26", R.drawable.card26);
            CARDS_IMAGES.put("27", R.drawable.card27);
            CARDS_IMAGES.put("28", R.drawable.card28);
            CARDS_IMAGES.put("29", R.drawable.card29);
            CARDS_IMAGES.put("30", R.drawable.card30);
            CARDS_IMAGES.put("31", R.drawable.card31);
            CARDS_IMAGES.put("32", R.drawable.card32);
            CARDS_IMAGES.put("33", R.drawable.card33);
            CARDS_IMAGES.put("34", R.drawable.card34);
            CARDS_IMAGES.put("35", R.drawable.card35);
        }

        /*
         * Take the card by the current player listener.
         */
        findViewById(R.id.takeIt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (table.finished() == true) {
                    Toast.makeText(GameActivity.this, R.string.the_game_finished_message, Toast.LENGTH_LONG).show();
                    return;
                }

                table.takeIt();
                table.endTurn();

                redraw();
            }
        });

        /*
         * Take the card by the current player listener.
         */
        findViewById(R.id.noThanks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (table.finished() == true) {
                    Toast.makeText(GameActivity.this, R.string.the_game_finished_message, Toast.LENGTH_LONG).show();
                    return;
                }

                table.noThanks();
                table.endTurn();

                redraw();
            }
        });

        redraw();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * Check which the selected item is in the options menu and depending on that star that activity
         */
        if (item.getItemId() == R.id.new_game) {
            findViewById(R.id.table).setVisibility(View.INVISIBLE);
            startActivityForResult(new Intent(GameActivity.this, PlayersActivity.class), LAUNCH_PLAYERS_LIST_ACTIVITY);
        }

        /*
        if (item.getItemId() == R.id.save_game) {

        }

        if (item.getItemId() == R.id.load_game) {

        }

        if (item.getItemId() == R.id.end_turn) {
        }
        */

        if (item.getItemId() == R.id.player_report && table.inProgress() == true) {
            startActivity(new Intent(GameActivity.this, PlayerReportActivity.class).putExtra("report", table.currentPlayerReport()));
        } else if (item.getItemId() == R.id.player_report) {
            Toast.makeText(GameActivity.this, R.string.the_game_is_not_in_progress_message, Toast.LENGTH_LONG).show();
        }

        if (item.getItemId() == R.id.end_report && table.inProgress() == false) {
            startActivity(new Intent(GameActivity.this, FinalReportActivity.class).putExtra("report", table.finalReport()));
        } else if (item.getItemId() == R.id.end_report) {
            Toast.makeText(GameActivity.this, R.string.the_game_not_finished_message, Toast.LENGTH_LONG).show();
        }

        if (item.getItemId() == R.id.help) {
            startActivity(new Intent(GameActivity.this, HelpActivity.class));
        }

        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(GameActivity.this, AboutActivity.class));
        }

        if (item.getItemId() == R.id.exit) {
            GameActivity.this.finish();
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*
         * Do not handle other results than OK.
         */
        if (resultCode != RESULT_OK) {
            return;
        }

        /*
         * Check if the result comes from launching the PlayersActivity
         */
        if (requestCode == LAUNCH_PLAYERS_LIST_ACTIVITY) {
            /*
             * Initialize a list to store player names
             */
            List<String> names = new ArrayList<String>();

            /*
             * Check each player's status and add their name to the list if enabled
             */
            if (data.getBooleanExtra("player1Enabled", false)) {
                names.add(data.getCharSequenceExtra("player1Name").toString());
            }
            if (data.getBooleanExtra("player2Enabled", false)) {
                names.add(data.getCharSequenceExtra("player2Name").toString());
            }
            if (data.getBooleanExtra("player3Enabled", false)) {
                names.add(data.getCharSequenceExtra("player3Name").toString());
            }
            if (data.getBooleanExtra("player4Enabled", false)) {
                names.add(data.getCharSequenceExtra("player4Name").toString());
            }
            if (data.getBooleanExtra("player5Enabled", false)) {
                names.add(data.getCharSequenceExtra("player5Name").toString());
            }
            if (data.getBooleanExtra("player6Enabled", false)) {
                names.add(data.getCharSequenceExtra("player6Name").toString());
            }
            if (data.getBooleanExtra("player7Enabled", false)) {
                names.add(data.getCharSequenceExtra("player7Name").toString());
            }

            /*
             * Convert the list of names to array of names.
             */
            if (table.newGame(names.toArray(new String[names.size()])) == false) {
                Toast.makeText(GameActivity.this, R.string.game_was_not_started_message, Toast.LENGTH_LONG).show();
            }

            /*
             * Sets the visibility of the game elements to visible
             */
            findViewById(R.id.table).setVisibility(View.VISIBLE);
        }

        redraw();
    }

    /**
     * After change in the object model the user interface should be updated.
     */
    void redraw() {
        if (table.inProgress() == false) {
            this.setTitle(getString(R.string.start_new_game_text));
        } else {
            /*
             * Set title of the screen with info for the gameplay.
             */
            setTitle(table.currentPlayerInfo());

            /*
             * Visualize the current chips on the card.
             */
            ((TextView) findViewById(R.id.currentChips)).setText("" + table.currentChips());
        }

        /*
         * Visualize the current card on the table.
         */
        ((ImageView) findViewById(R.id.currentCard)).setImageResource(CARDS_IMAGES.get(table.currentCardKey()));
    }
}
