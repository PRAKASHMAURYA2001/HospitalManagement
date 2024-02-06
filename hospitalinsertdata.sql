use hospital;
-- Insert sample records into Patient table
INSERT INTO Patient (firstName, lastName, dateOfBirth, gender, contactNumber, address)
VALUES
    ('Amit', 'Patel', '1992-06-20', 'M', '9876543210', 'Mumbai'),
    ('Sneha', 'Verma', '1988-12-15', 'F', '8765432109', 'Delhi'),
    ('Rahul', 'Sharma', '1975-04-08', 'M', '7890123456', 'Bangalore'),
    ('Priya', 'Singh', '1998-02-18', 'F', '7654321098', 'Kolkata'),
    ('Vikram', 'Yadav', '1984-09-25', 'M', '6543210987', 'Chennai');

-- Insert sample records into Doctor table
INSERT INTO Doctor (firstName, lastName, specialization, contactNumber)
VALUES
    ('Dr. Ananya', 'Gupta', 'Cardiologist', '1122334455'),
    ('Dr. Rajesh', 'Mishra', 'Dermatologist', '3344556677'),
    ('Dr. Nisha', 'Kapoor', 'Pediatrician', '5566778899'),
    ('Dr. Vikas', 'Malhotra', 'Orthopedic Surgeon', '7788990011'),
    ('Dr. Priyanka', 'Chopra', 'Psychiatrist', '9900112233');

-- Insert sample records into Appointment table
INSERT INTO Appointment (patientId, doctorId, appointmentDate, description)
VALUES
    (101, 02, '2024-02-10', 'Routine checkup'),
    (103, 04, '2024-02-15', 'Follow-up on previous treatment'),
    (102, 01, '2024-02-18', 'Skin condition evaluation'),
    (104, 03, '2024-02-20', 'Pediatric checkup'),
    (105, 05, '2024-02-25', 'Psychiatric consultation');