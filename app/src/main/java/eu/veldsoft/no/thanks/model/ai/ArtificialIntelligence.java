package eu.veldsoft.no.thanks.model.ai;

import eu.veldsoft.no.thanks.model.Table;

/**
 * Root of artificial intelligence class tree.
 */
public interface ArtificialIntelligence {
    /**
     * Decision making procedure.
     *
     * @param table The table information.
     * @return The decision taken.
     */
    public Choice decision(Table table);

    /**
     * The two possible choices.
     */
    public static enum Choice {TAKE_IT, NO_THANKS}
}

