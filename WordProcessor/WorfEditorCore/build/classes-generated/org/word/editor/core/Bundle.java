package org.word.editor.core;
/** Localizable strings for {@link org.word.editor.core}. */
class Bundle {
    /**
     * @return <i>Word</i>
     * @see WordTopComponent
     */
    static String CTL_WordAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_WordAction");
    }
    /**
     * @return <i>Word Window</i>
     * @see WordTopComponent
     */
    static String CTL_WordTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_WordTopComponent");
    }
    /**
     * @return <i>This is a Word window</i>
     * @see WordTopComponent
     */
    static String HINT_WordTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_WordTopComponent");
    }
    private Bundle() {}
}
