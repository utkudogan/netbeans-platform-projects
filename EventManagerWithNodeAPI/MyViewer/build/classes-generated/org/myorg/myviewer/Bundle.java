package org.myorg.myviewer;
/** Localizable strings for {@link org.myorg.myviewer}. */
class Bundle {
    /**
     * @return <i>MyViewer</i>
     * @see MyViewerTopComponent
     */
    static String CTL_MyViewerAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_MyViewerAction");
    }
    /**
     * @return <i>MyViewer Window</i>
     * @see MyViewerTopComponent
     */
    static String CTL_MyViewerTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_MyViewerTopComponent");
    }
    /**
     * @return <i>This is a MyViewer window</i>
     * @see MyViewerTopComponent
     */
    static String HINT_MyViewerTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_MyViewerTopComponent");
    }
    private Bundle() {}
}
