package nl.delphinity.pokemon.model.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import nl.delphinity.pokemon.model.trainer.Trainer;

public class PokemonToFile implements Serializable {

//	public static void save(Trainer trainer) {

//		FileOutputStream fout = null;
//		ObjectOutputStream oos = null;
//		
//		try {
//			fout = new FileOutputStream("E:\\\\One drive kanker\\\\Documenten\\\\school\\\\programmeren\\\\sprint 4\\\\pokemon.txt");
//			oos = new ObjectOutputStream(fout);
//			oos.writeObject(trainer);
//			fout.close();
//			oos.close();
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		Trainer trainer1 = new Trainer(null, null);
//		try {
//			File file = new File(
//					"E:\\\\One drive kanker\\\\Documenten\\\\school\\\\programmeren\\\\sprint 4\\\\pokemon.ser");
//			FileWriter filewriter = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter writer = new BufferedWriter(filewriter);
//			writer.write(trainer1);
//			writer.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void load() {
//
//		System.out.println("Loading game...");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			FileInputStream fileIn = new FileInputStream(
//					"E:\\\\One drive kanker\\\\Documenten\\\\school\\\\programmeren\\\\sprint 4\\\\pokemon.ser");
//			ObjectInputStream in = new ObjectInputStream(fileIn);
//			Game.trainer = (Trainer) in.readObject();
//			in.close();
//			fileIn.close();
//		} catch (IOException i) {
//			i.printStackTrace();
//			return;
//		} catch (ClassNotFoundException c) {
//			System.out.println("class not found");
//			c.printStackTrace();
//			return;
//		}
//
//	}
}
