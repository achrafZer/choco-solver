package com.example.chocosolver;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.chocosolver.problem.Problem;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	private String problemText;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("problemText", problemText);
		return modelAndView;
	}

	@PostMapping("/solve")
	public ModelAndView solveProblem(@RequestParam("problem") String problemText, HttpServletRequest request)
			throws IOException {
		this.problemText = problemText;
		Problem p = new Problem(problemText);
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();

		if (p.isError()) {
			System.out.println("elie:" + p.getErrorMessage());
			modelAndView.setViewName("home");
			modelAndView.addObject("errormessage", p.getErrorMessage());
			modelAndView.addObject("problemText", problemText);
			modelAndView.addObject("error", p.isError());
		} else {
			List<HashMap<String, Integer>> solution = p.solve();
			modelAndView.setViewName("response");
			modelAndView.addObject("p", p);
			modelAndView.addObject("solution", solution);
			modelAndView.addObject("problem", formatProblemWithNewLines(problemText));
			session.setAttribute("problem", formatProblemWithNewLines(problemText));
			session.setAttribute("solution", solution);
			session.setAttribute("p", p);
		}
		return modelAndView;
	}

	@GetMapping("/solve")
	public ModelAndView handleSolveWithoutProblem() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}

	private String formatProblemWithNewLines(String problemText) {
		return problemText.replace(";", ";\n").trim();
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("errormessage", "An unexpected error occurred: " + ex.getMessage());
		return modelAndView;
	}

	@GetMapping("/save")
	public ModelAndView saveSolution(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Problem problem=(Problem) session.getAttribute("p");
		problem.setSaved(true);
		String p = (String) session.getAttribute("problem");
		List<HashMap<String, Integer>> solution = (List<HashMap<String, Integer>>) session.getAttribute("solution");
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd-HHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
		try {
			saveResult(solution, p, formattedDateTime.toString());
			modelAndView.setViewName("response");
			modelAndView.addObject("solution", solution);
			modelAndView.addObject("problem", p);
			modelAndView.addObject("isSaved", problem.isSaved());
			String saveMessage="Solution data saved to CSV file: "+formattedDateTime.toString();
			modelAndView.addObject("saveMessage",saveMessage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   return modelAndView;
	}
	
	public void saveResult(List<HashMap<String, Integer>> solution, String problem, String fileName)
			throws IOException {
		String csvFilePath = "C:/Users/Admin/Downloads/" + fileName + ".csv";
		try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(csvFilePath), CSVFormat.DEFAULT)) {
			csvPrinter.print("# Problem : ");
			csvPrinter.print(problem);
			csvPrinter.println();
			csvPrinter.print("#S");
			for (String key : solution.get(0).keySet()) {
				csvPrinter.print(key);
			}
			csvPrinter.println();
			int s = 1;
			for (HashMap<String, Integer> rowData : solution) {
				csvPrinter.print(s++);
				for (String key : rowData.keySet()) {
					csvPrinter.print(rowData.get(key));
				}
				csvPrinter.println();
			}

			csvPrinter.flush();
			System.out.println("Solution data saved to CSV file: " + csvFilePath);
		} catch (IOException e) {
			System.err.println("Error saving solution data to CSV file: " + e.getMessage());
		}
	}

}
