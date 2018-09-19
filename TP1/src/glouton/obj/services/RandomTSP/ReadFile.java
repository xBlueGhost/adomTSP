package glouton.obj.services.RandomTSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import glouton.obj.RandomTSP;

public class ReadFile {

	public static RandomTSP readFile(File f) {
		String fileName = null;
		String name = null;
		Integer n = null;
		Integer seed = null;
		String type = null;
		Integer dimension = null;
		String edgeWeightType = null;
		String edgeWeightFormat = null;
		int[][] edgeWeightSection = null;

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			fileName = f.getName();
			String line;
			int count = 0;
			int i = 0;
			int j = 0;
			while ((line = br.readLine()) != null) {
				count++;
				switch (count) {
				case 1:
					name = line.split("NAME : ")[1];
					break;
				case 2:
					n = Integer.parseInt(line.split("COMMENT : portmgen N=")[1].split(",")[0]);
					seed = Integer.parseInt(line.split(", seed=")[1]);
					break;
				case 3:
					type = line.split("TYPE : ")[1];
					break;
				case 4:
					dimension = Integer.parseInt(line.split("DIMENSION : ")[1]);
					break;
				case 5:
					edgeWeightType = line.split("EDGE_WEIGHT_TYPE : ")[1];
					break;
				case 6:
					edgeWeightFormat = line.split("EDGE_WEIGHT_FORMAT : ")[1];
					break;
				case 7:
					edgeWeightSection = new int[dimension][dimension];
					break;

				default:
					edgeWeightSection[i][j] = Integer.parseInt(line);
					edgeWeightSection[j][i] = Integer.parseInt(line);
					if (j == 99) {
						i++;
						j = i;
					} else {
						j++;
					}
					break;
				}
			}
			System.out.println("[INFO] : Number line count in file " + f.getName() + " = " + count);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		RandomTSP rTsp = new RandomTSP(fileName, name, n, seed, type, dimension, edgeWeightType, edgeWeightFormat);
		rTsp.setEdgeWeightSection(edgeWeightSection);
		return rTsp;
	}

}
