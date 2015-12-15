package com.krotic.lutec.kroticprogramer;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Andres on 12/15/2015.
 * This class is a {@link android.support.v7.app.AlertDialog} that could have a custom
 * view and a custom actions.
 */
public abstract class OPDialog {

/*----------------------------------------Constants-----------------------------------------------*/



/*-----------------------------------------Flags--------------------------------------------------*/
    /**
     * If this flag is true, the action of the positive button will set it. In other case the button
     * does nothing
     */
    private boolean isPositiveButton;

    /**
     * If this flag is true, the action of the negative button will set it. In other case the button
     * does nothing
     */
    private boolean isNegativeButton;


/*---------------------------------------Class variables------------------------------------------*/
    /**
     * It creates the {@link AlertDialog}
     */
    private AlertDialog.Builder builder;

    /**
     * Integer that identify the Layout that fills the {@link AlertDialog}
     */
    private int layout_id;

    /**
     * {@link View} that fills the {@link AlertDialog}
     */
    private View view;

/*----------------------------------------Class methods-------------------------------------------*/

    /**
     * Constructor
     *
     * @param activity {@link Activity} where the {@link AlertDialog} will be created.
     *
     * @param layout_id Layout that fills the {@link AlertDialog}
     */
    public OPDialog(Activity activity, int layout_id) {
        LayoutInflater inflater = activity.getLayoutInflater();
        this.layout_id = layout_id;

        /*The builder is created*/
        builder = new AlertDialog.Builder(activity);

        /*The View is created*/
        view = inflater.inflate(layout_id, null);

        /*The View is set it to make custom actions*/
        view = fillView(view);

        builder.setView(view);
    }

    /**
     * Set the {@link AlertDialog} positive button
     *
     * @param positiveTextButton Text that is showed in the button
     */
    public void setPositiveButton(String positiveTextButton){

        builder.setPositiveButton(positiveTextButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onPositiveButton(view);
            }
        });
    }

    /**
     * Set the {@link AlertDialog} negative button
     *
     * @param negativeTextButton Text that is showed in the button
     */
    public void setNegativeButton(String negativeTextButton){
        builder.setNegativeButton(negativeTextButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onNegativeButton(view);
            }
        });
    }

    /**
     * Creates the final {@link AlertDialog}
     *
     * @return {@link AlertDialog} that contains the view and the actions of the buttons
     */
    public AlertDialog getAlertDialog(){
        return builder.create();
    }

    /**
     * This method set the {@link View} of the {@link AlertDialog}
     *
     * @param view {@link View} of the {@link AlertDialog}
     *
     * @return the complete {@link View}
     */
    public abstract View fillView(View view);

    /**
     * Sets the positive action of the {@link AlertDialog}
     * @param view {@link View} of the {@link AlertDialog}
     */
    public abstract void onPositiveButton(View view);

    /**
     * Sets the negative action of the {@link AlertDialog}
     * @param view {@link View} of the {@link AlertDialog}
     */
    public abstract void onNegativeButton(View view);


}
