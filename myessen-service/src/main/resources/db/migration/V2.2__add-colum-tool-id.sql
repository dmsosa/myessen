ALTER TABLE leben
ADD fk_tool_id INT FOREIGN KEY REFERENCES Tools(tool_id);