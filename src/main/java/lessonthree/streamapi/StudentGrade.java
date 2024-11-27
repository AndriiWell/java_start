package lessonthree.streamapi;

/**
 * Map the grades from the filtered students into a stream of custom StudentGrade (expected to be record) records, containing the following fields:
 *
 * @param studentName Name of the student associated with the grade
 * @param school Name of the student’s school
 * @param subject (Name of the subject
 * @param score Score for the subject
 */
public record StudentGrade(String studentName, String school, String subject, double score) { }
