package com.project.little_collectipair;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import com.google.ar.core.Anchor;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Frame;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.Session;
import com.google.ar.core.TrackingState;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Camera;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.SkeletonNode;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.Material;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import android.os.Build.VERSION_CODES;
import androidx.fragment.app.FragmentActivity;

import java.util.Collection;

//TEST Denny ist ein plöder pursche und iich haue ihn gleich zu poden
public class MainActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private ModelRenderable tireRenderable;
    private boolean isModelPlaced = false;

    private int level_id;
    private int item_count;
    private boolean karosse;
    private int reifen_count;
    private int star_count;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item_count = 0;
        level_id = getIntent().getIntExtra("LVL_ID", 99);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);

        arFragment.getArSceneView().getScene().addOnUpdateListener(this::onUpdate);


    }

    private void onUpdate(FrameTime frameTime) {

        if(isModelPlaced)
            return;


        Frame frame = arFragment.getArSceneView().getArFrame();

        Collection<Plane> planes = frame.getUpdatedTrackables(Plane.class);

        System.out.println("test");

        for(Plane plane : planes) {

            if(plane.getTrackingState() == TrackingState.TRACKING){

                Anchor anchor = plane.createAnchor(plane.getCenterPose());

                makeCube(anchor);

                break;
            }

        }

    }

    private void startTimer() {

        TextView timer = findViewById(R.id.Fehler);
        new Thread(() -> {
            int seconds = 0;
            int minutesPassed = seconds / 60;
            int secondsPassed = seconds % 60;
            runOnUiThread(() -> timer.setText("Denny")
            );
        }).start();
    }

    private void makeCube(Anchor anchor) {

        isModelPlaced = true;

        switch (level_id) {
            case 1:
                RenderableModel_LVL1(anchor);
                break;
            case 2:
                RenderableModel_LVL2(anchor);
                break;
            case 3:
                RenderableModel_LVL3(anchor);
                break;
            case 99:
                RenderableModel_LVL99(anchor);
                break;
            default:
                break;
        }


    }

    private void RenderableModel_LVL1(Anchor anchor)
    {
        int rnd_count;
        String[] sfbfiles = {"reifen.sfb", "stern.sfb", "autokarosse.sfb"};

        rnd_count = (karosse == false ? 1 : 0) + (reifen_count < 4 ? 1 : 0) + (star_count < 2 ? 1 : 0);

        Random r = new Random();
        int i = r.nextInt(rnd_count);

        //Temp. stern.sfb dont exist atm
        i = 0;

        ModelRenderable.builder()
                .setSource(this, Uri.parse(sfbfiles[i]))
                .build()
                .thenAccept(tireRenderable -> {
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    SkeletonNode skeletonNode = new SkeletonNode();
                    skeletonNode.setParent(anchorNode);
                    skeletonNode.setRenderable(tireRenderable);


                    arFragment.getArSceneView().getScene().addChild(anchorNode);
                });
    }

    private void RenderableModel_LVL2(Anchor anchor)
    {
        String[] sfbfiles = {"1", "2", "3", "4", "5"};


        ModelRenderable.builder()
                .setSource(this, Uri.parse(sfbfiles[item_count++]))
                .build()
                .thenAccept(tireRenderable -> {;
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    SkeletonNode skeletonNode = new SkeletonNode();
                    skeletonNode.setParent(anchorNode);
                    skeletonNode.setRenderable(tireRenderable);


                    arFragment.getArSceneView().getScene().addChild(anchorNode);
                });
    }

    private void RenderableModel_LVL3(Anchor anchor)
    {
        String[] sfbfiles = {"1", "2", "3", "4", "5", "7"};
        ModelRenderable.builder()
                .setSource(this, Uri.parse(sfbfiles[item_count++]))
                .build()
                .thenAccept(tireRenderable -> {
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    SkeletonNode skeletonNode = new SkeletonNode();
                    skeletonNode.setParent(anchorNode);
                    skeletonNode.setRenderable(tireRenderable);


                    arFragment.getArSceneView().getScene().addChild(anchorNode);
                });
    }

    private void RenderableModel_LVL99(Anchor anchor)
    {
        String[] sfbfiles = {"1"};
        ModelRenderable.builder()
                .setSource(this, Uri.parse("reifen.sfb"))
                .build()
                .thenAccept(tireRenderable -> {
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    SkeletonNode skeletonNode = new SkeletonNode();
                    skeletonNode.setParent(anchorNode);
                    skeletonNode.setRenderable(tireRenderable);


                    arFragment.getArSceneView().getScene().addChild(anchorNode);
                });
    }
}