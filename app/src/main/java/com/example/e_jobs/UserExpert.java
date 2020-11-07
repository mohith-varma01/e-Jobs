package com.example.e_jobs;

import com.example.e_jobs.Adapter.UserAdapter;
import com.example.e_jobs.Modal.User;

import java.util.ArrayList;

public class UserExpert
{
    UserAdapter userAdapter;
    ArrayList<User> users ;

    public UserExpert(UserAdapter adapter)
    {
        this.userAdapter = adapter;
        users = adapter.getAllUsers();
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public User getUser(String email)
    {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserMailAddress().equals(email))
            {
                return users.get(i);
            }
        }
        return null;
    }

    public int getTotalUsers()
    {
        return users.size();
    }
}