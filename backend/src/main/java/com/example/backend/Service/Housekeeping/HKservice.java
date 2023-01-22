package com.example.backend.Service.Housekeeping;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.example.Expections.HKtask.TaskNotFoundException;
import com.example.backend.model.housekeeping.Task;

@Service
public class HKservice {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Task> getTasks() {
        String sql = "select id, name ,description, status from tasks";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<Task> tasks = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            long id = (long) row.get("id");
            String name = (String) row.get("name");
            String description = (String) row.get("description");
            String status = (String) row.get("status");

            tasks.add(new Task(id, name, description, status));
        }

        return tasks;

    }

    public Task create(Task task) {
        String sql = "insert into tasks (name, description, status) values (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, task.getName());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            return ps;
        }, keyHolder);
        task.setId(keyHolder.getKey().longValue());
        return task;
    }

    public Task updateTask(String name, Task task) {
        String sql = "select id from tasks where name=?";
        long id = jdbcTemplate.queryForObject(sql, Long.class, name);

        sql = "update task set status=? where id = ?";
        int rowsAffected = jdbcTemplate.update(sql, task.getStatus(), id);
        if (rowsAffected > 0) {
            return task;
        }
        throw new TaskNotFoundException();
    }

}
