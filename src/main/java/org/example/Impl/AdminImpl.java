package org.example.Impl;

import org.example.entity.Reservation;
import org.example.interfaces.AdminInterface;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminImpl implements AdminInterface {

    private static final String RESERVATIONS_FILE_PATH = "reservations.csv";
    private List<Reservation> reservations = new ArrayList<>();

    public AdminImpl() {
        loadReservations();
    }

    @Override
    public void showRoomReservations() {
        for (Reservation reservation : reservations) {
            System.out.println("Reservation id: " + reservation.getReservationId()
                    + ", Room id: " + reservation.getRoomId()
                    + ", User id: " + reservation.getUserId()
                    + ", Check-in Date: " + reservation.getCheckInDate()
                    + ", Check-out Date: " + reservation.getCheckOutDate()
                    + ", Status: " + reservation.getStatus());
        }
    }

    @Override
    public String acceptRoomReserve(int reserveId) {
        return updateReservationStatus(reserveId, "ACCEPTED");
    }

    @Override
    public String declienRoomReserve(int reserveId) {
        return updateReservationStatus(reserveId, "DECLINED");
    }

    private String updateReservationStatus(int reserveId, String newStatus) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reserveId) {
                reservation.setStatus(newStatus);
                saveReservations(); // Save updated reservations to file
                return "Reservation successfully " + (newStatus.equals("ACCEPTED") ? "Accepted!" : "Declined!");
            }
        }
        return "Reservation not found.";
    }

    private void saveReservations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATIONS_FILE_PATH))) {
            for (Reservation reservation : reservations) {
                writer.write(reservation.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving reservations: " + e.getMessage());
        }
    }

    private void loadReservations() {
        File file = new File(RESERVATIONS_FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    reservations.add(Reservation.fromCSV(line));
                }
            } catch (IOException e) {
                System.err.println("Error loading reservations: " + e.getMessage());
            }
        }
    }
}
