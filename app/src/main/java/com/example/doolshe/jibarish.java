package com.example.doolshe;


    public class jibarish extends AppCompatActivity {

        EditText etStudentID, etPhysics, etChemistry, etBioMaths, etAverage;
        Button addMarksBtn, updateMarksBtn, deleteMarksBtn, btnShowAvg;
        DatabaseReference dbref;
        Marks marks;
    /long maxid=0;/

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_manage_marks);
            etStudentID = (EditText) findViewById(R.id.etStudentID);
            etPhysics = (EditText)findViewById(R.id.etPhysics);
            etChemistry = (EditText)findViewById(R.id.etChemistry);
            etBioMaths = (EditText)findViewById(R.id.etBioMaths);
            etAverage = (EditText)findViewById(R.id.etAverage);
            btnShowAvg = (Button) findViewById(R.id.btnShowAvg);
            addMarksBtn = (Button) findViewById(R.id.addMarksBtn);
            updateMarksBtn = (Button) findViewById(R.id.updateMarksBtn);
            deleteMarksBtn = (Button) findViewById(R.id.deleteMarksBtn);

            marks = new Marks();
            dbref = FirebaseDatabase.getInstance().getReference().child("Marks");
        /*dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/


            addMarksBtn.setOnClickListener(view -> {
                marks.setStudentID(etStudentID.getText().toString().trim());
                String sid = marks.getStudentID();
                Double physics = Double.parseDouble(etPhysics.getText().toString());
                marks.setPhysics(physics);
                Double chemistry = Double.parseDouble(etChemistry.getText().toString());
                marks.setChemistry(chemistry);
                Double biomaths= Double.parseDouble(etBioMaths.getText().toString());
                marks.setBioMaths(biomaths);
                clearAll();
            /*marks.setAverage(physics, chemistry, biomaths);
            Double average = marks.getAverage();*/

            /dbref.child(String.valueOf(maxid+1)).setValue(marks);/

                dbref.push().getKey();
                Marks marks = new Marks(sid, physics, chemistry, biomaths);
                dbref.child(sid).setValue(marks);
                Toast.makeText(ManageMarksActivity.this, "Data Inserted Successfully.", Toast.LENGTH_LONG).show();
            });

            deleteMarksBtn.setOnClickListener(view ->{
                marks.setStudentID(etStudentID.getText().toString().trim());
                String sid = marks.getStudentID();
                deleteMarks(sid);

            });

            updateMarksBtn.setOnClickListener(view ->{
                marks.setStudentID(etStudentID.getText().toString().trim());
                String sid = marks.getStudentID();
                Double physics = Double.parseDouble(etPhysics.getText().toString());
                marks.setPhysics(physics);
                Double chemistry = Double.parseDouble(etChemistry.getText().toString());
                marks.setChemistry(chemistry);
                Double biomaths= Double.parseDouble(etBioMaths.getText().toString());
                marks.setBioMaths(biomaths);
           /*marks.setAverage(physics, chemistry, biomaths);
           Double average = marks.getAverage();*/
                updateMarks(sid, physics, chemistry, biomaths);
            });

            btnShowAvg.setOnClickListener(view ->{
                Double physics = Double.parseDouble(etPhysics.getText().toString());
                Double chemistry = Double.parseDouble(etChemistry.getText().toString());
                Double biomaths= Double.parseDouble(etBioMaths.getText().toString());
                calcStudentAverage(physics, chemistry, biomaths);
            });




        }

        public void deleteMarks(String sid){

            dbref = FirebaseDatabase.getInstance().getReference().child("Marks").child(sid);
            dbref.removeValue();
            Toast.makeText(ManageMarksActivity.this, "Data deleted successfully", Toast.LENGTH_LONG).show();
            clearAll();
        }

        public void updateMarks(String sid, Double physics, Double chemistry, Double biomaths){
            dbref = FirebaseDatabase.getInstance().getReference().child("Marks").child(sid);
            Marks marks = new Marks(sid, physics, chemistry, biomaths);
            dbref.setValue(marks);
            Toast.makeText(ManageMarksActivity.this, "Marks updated successfully", Toast.LENGTH_LONG).show();
            clearAll();
        }

        public void calcStudentAverage(Double physics, Double chemistry, Double biomaths){
            Double avg = (physics+chemistry+biomaths)/3.0;
            String avgString = Double.toString(avg);
            etAverage.setText(avgString);
        }

        public void clearAll(){
            etStudentID.setText("");
            etPhysics.setText("");
            etChemistry.setText("");
            etBioMaths.setText("");
            etAverage.setText("");
        }






    }

}
